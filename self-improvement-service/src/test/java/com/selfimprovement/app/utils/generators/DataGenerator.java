package com.selfimprovement.app.utils.generators;

import com.github.javafaker.Faker;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.model.PetEntity;
import lombok.experimental.UtilityClass;

import javax.annotation.Nullable;
import java.util.Optional;

@UtilityClass
public class DataGenerator {

    public static PetEntity.PetEntityBuilder buildPetEntity(Faker faker) {
        return PetEntity.builder()
                .name(faker.name().name());
    }

    public static PetDto.PetDtoBuilder buildPetDto(Faker faker) {
        return PetDto.builder()
                .name(faker.name().name());
    }

    public static com.selfimprovement.app.server.openapi.model.PetDto
    buildPetDtoResponse(Faker faker, @Nullable String name) {
        var petDto = new com.selfimprovement.app.server.openapi.model.PetDto();
        petDto.setName(Optional.ofNullable(name).orElse(faker.name().name()));
        return petDto;
    }
}
