package com.prueba.api.service.Impl;

import com.prueba.api.Utility.Base64Hash;
import com.prueba.api.Utility.Mapper;
import com.prueba.api.dto.MockDto;
import com.prueba.api.model.Mock;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@RequiredArgsConstructor
public class MockServiceImpl {

    @Value("${spring.external.service.base-url2}")
    private String baseUrl2;

    private final RestTemplate restTemplate;

   /* public MockDto getAll(){
        MockDto response = restTemplate.getForObject(baseUrl2+"json/1", MockDto.class);
        return response;
    }*/

    public MockDto getAll(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        /*headers.add("Authorization", "Basic YWRtaW46MTIzNA==");*/
        headers.add("Authorization", "Basic "+ Base64Hash.hash("admin", "1234"));
        ResponseEntity<Mock> response = restTemplate.exchange(baseUrl2+"json/1",
                HttpMethod.GET,
                new HttpEntity<>(headers),
                Mock.class);
        return Mapper.builMockDto(response.getBody());
    }
}
