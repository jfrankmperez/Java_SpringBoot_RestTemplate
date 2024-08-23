package com.prueba.api.controller;

import com.prueba.api.dto.PersonDto;
import com.prueba.api.service.Impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class personController {

    private final PersonServiceImpl personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> getAll(){
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> getById(@PathVariable Integer id){
        return new ResponseEntity<>(personService.getByIdPerson(id), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void savePerson(@RequestBody PersonDto personDto){
    personService.savePerson(personDto);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePerson(@PathVariable Integer id, @RequestBody PersonDto personDto){
    personService.updatePerson(id,personDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletePerson(@PathVariable Integer id){
    personService.daletePerson(id);
    }
}
