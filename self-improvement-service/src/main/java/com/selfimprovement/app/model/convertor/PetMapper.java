package com.selfimprovement.app.model.convertor;

import com.selfimprovement.app.model.PetDto;
import com.selfimprovement.model.PetEntity;

public class PetMapper {

    public static PetDto mapToPetDto(PetEntity petEntity) {
        return PetDto.builder()
                .name(petEntity.getName())
                .build();
    }
}
