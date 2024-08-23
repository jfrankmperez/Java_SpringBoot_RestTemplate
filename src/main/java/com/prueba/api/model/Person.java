package com.prueba.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Person {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private String avatar;
}
