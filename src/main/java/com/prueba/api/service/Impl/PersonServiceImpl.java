package com.prueba.api.service.Impl;

import com.prueba.api.Utility.MessajeResponse;
import com.prueba.api.dto.PersonDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl {

    @Value("${spring.external.service.base-url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public ResponseEntity<?> getPersonsAll(){
        PersonDto[] response = restTemplate.getForObject(baseUrl+"users", PersonDto[].class);
        return new ResponseEntity<>(MessajeResponse.builder()
                .msn("List")
                .object(response)
                .build(), HttpStatus.OK);
    }

    public ResponseEntity<?> savePerson(PersonDto personDto){
        restTemplate.postForObject(baseUrl+"users",personDto, PersonDto.class);
        return new ResponseEntity<>(MessajeResponse.builder()
                .msn("Registered")
                .object(null)
                .build(),HttpStatus.CREATED);
    }


    public ResponseEntity<?> updatePerson(PersonDto personDto){
        try {
            restTemplate.put(baseUrl+"users/"+personDto.getId(), personDto);
            return new ResponseEntity<>(MessajeResponse.builder()
                    .msn("Updated")
                    .object(personDto)
                    .build(), HttpStatus.OK);
        } catch (HttpClientErrorException exception){
            return new ResponseEntity<>(MessajeResponse.builder()
                    .msn("Failed o update")
                    .object(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> daletePerson(Integer id){
        List<PersonDto> list = new ArrayList<>();
        list.add(restTemplate.getForObject(baseUrl+"users/"+id, PersonDto.class));
        restTemplate.delete(baseUrl+"users/"+id);
        return new ResponseEntity<>(MessajeResponse.builder()
                .msn("Deleted")
                .object(list)
                .build(), HttpStatus.OK);
    }

    public ResponseEntity<?> getByIdPerson(Integer id) {
        List<PersonDto> list = new ArrayList<>();
        list.add(restTemplate.getForObject(baseUrl+"users/"+id, PersonDto.class));
        return new ResponseEntity<>(MessajeResponse.builder()
                .msn("Found")
                .object(list)
                .build(), HttpStatus.FOUND);
    }
}
