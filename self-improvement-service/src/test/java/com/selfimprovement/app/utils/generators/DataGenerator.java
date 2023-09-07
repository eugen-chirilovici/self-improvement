package com.selfimprovement.app.utils.generators;

import com.github.javafaker.Faker;
import com.selfimprovement.model.PetEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataGenerator {

    public static PetEntity.PetEntityBuilder buildPetEntity(Faker faker) {
        return PetEntity.builder()
                .name(faker.name().name());
    }
}
