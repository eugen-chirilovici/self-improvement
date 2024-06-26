package com.selfimprovement.app.utils.generators;

import com.github.javafaker.Faker;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.app.server.openapi.model.Data;
import com.selfimprovement.app.server.openapi.model.InitFlowResponse;
import com.selfimprovement.app.server.openapi.model.Pet;
import com.selfimprovement.model.PetEntity;
import lombok.experimental.UtilityClass;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class DataGenerator {

    public static PetEntity.PetEntityBuilder buildPetEntity(Faker faker) {
        return PetEntity.builder().name(faker.name().name());
    }

    public static PetDto.PetDtoBuilder buildPetDto(Faker faker) {
        return PetDto.builder().name(faker.name().name());
    }

    public static Pet buildPet(Faker faker, @Nullable String name) {
        return new Pet().name(
                Optional.ofNullable(name).orElse(faker.name().name()));
    }

    public static InitFlowResponse buildInitFlowResponse(Faker faker, @Nullable String name) {
        return new InitFlowResponse().data(
                new Data().pets(
                        List.of(buildPet(faker, name))));
    }
}
