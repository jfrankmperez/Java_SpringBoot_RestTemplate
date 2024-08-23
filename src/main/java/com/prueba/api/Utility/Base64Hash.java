package com.prueba.api.Utility;

import lombok.experimental.UtilityClass;

import java.util.Base64;

@UtilityClass
public class Base64Hash {

    public String hash(String user, String pass){
        String credencial = user+":"+pass;
        return new String(Base64.getEncoder().encodeToString(credencial.getBytes()));
    }

}
