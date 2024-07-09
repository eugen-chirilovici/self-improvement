package com.selfimprovement.app.utils.generators;

import com.github.javafaker.Faker;
import com.selfimprovement.app.model.PetData;
import com.selfimprovement.app.model.InitPetFlowResponse;
import com.selfimprovement.app.model.dto.PetDto;
import com.selfimprovement.model.PetEntity;
import lombok.experimental.UtilityClass;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class PetsGenerator {

    public static PetEntity.PetEntityBuilder buildPetEntity(Faker faker) {
        return PetEntity.builder().name(faker.name().name());
    }

    public static PetDto.PetDtoBuilder buildPetDto(Faker faker, @Nullable String name) {
        return PetDto.builder().name(
                Optional.ofNullable(name).orElse(faker.name().name()));
    }

    public static InitPetFlowResponse.InitPetFlowResponseBuilder buildInitFlowResponse(Faker faker, @Nullable String name) {
        return InitPetFlowResponse.builder()
                .data(PetData.builder()
                        .pets(List.of(buildPetDto(faker, name).build()))
                        .build());
    }
}
