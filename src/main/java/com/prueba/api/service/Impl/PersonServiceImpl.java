package com.prueba.api.service.Impl;

import com.prueba.api.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl {

    @Value("${spring.external.service.base-url}")
    private String baseUrl;


    private final RestTemplate restTemplate;

    public List<PersonDto> getPersons(){
        PersonDto[] response = restTemplate.getForObject(baseUrl+"users", PersonDto[].class);
        return Arrays.asList(response);
    }

    public void savePerson(PersonDto personDto){
    restTemplate.postForObject(baseUrl+"users",personDto, PersonDto.class);
    }
    public void updatePerson(Integer id, PersonDto personDto){
    restTemplate.put(baseUrl+"users/"+id, personDto);
    }
    public void daletePerson(Integer id){
    restTemplate.delete(baseUrl+"users/"+id);
    }

    public PersonDto getByIdPerson(Integer id) {
        PersonDto response = restTemplate.getForObject(baseUrl+"users/"+id, PersonDto.class);
        return response;
    }
}
