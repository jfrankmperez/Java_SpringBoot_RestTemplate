package com.prueba.api.Utility;

import com.prueba.api.dto.MockDto;
import com.prueba.api.model.Mock;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Mapper {

    public MockDto builMockDto(Mock mock){
        return new MockDto(mock.getId(),mock.getValue());
    }
}
