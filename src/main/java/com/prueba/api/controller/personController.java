package com.prueba.api.controller;

import com.prueba.api.dto.PersonDto;
import com.prueba.api.service.Impl.PersonServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.5/persons")
@RequiredArgsConstructor
public class personController {

    private final PersonServiceImpl personService;

    @GetMapping
    public ResponseEntity<?> getAll(){
        return personService.getPersonsAll();
    }

    @PostMapping
    public ResponseEntity<?> savePerson(@RequestBody PersonDto personDto){
        return personService.savePerson(personDto);
    }

    @PutMapping
    public ResponseEntity<?> updatePerson(@RequestBody PersonDto personDto){
        return personService.updatePerson(personDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return personService.getByIdPerson(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Integer id){
    return personService.daletePerson(id);
    }
}
