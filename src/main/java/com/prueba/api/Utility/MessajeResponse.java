package com.prueba.api.Utility;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MessajeResponse implements Serializable {
    private String msn;
    private Object object;
}
