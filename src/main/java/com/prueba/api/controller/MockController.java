package com.prueba.api.controller;

import com.prueba.api.dto.MockDto;
import com.prueba.api.service.Impl.MockServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api2/v2")
@RequiredArgsConstructor
public class MockController {

    private final MockServiceImpl mockService;

    @GetMapping
    public ResponseEntity<MockDto> getAll(){
        return new ResponseEntity<>(mockService.getAll(), HttpStatus.OK);
    }

}
