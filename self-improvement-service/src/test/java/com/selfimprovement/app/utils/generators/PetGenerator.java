package com.selfimprovement.app.utils.generators;

import com.selfimprovement.app.model.PetDto;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PetGenerator {
    public static PetDto buildPetDto(String name) {
        return PetDto.builder().name(name).build();
    }
}
