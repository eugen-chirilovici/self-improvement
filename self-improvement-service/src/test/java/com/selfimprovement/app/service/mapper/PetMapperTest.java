package com.selfimprovement.app.service.mapper;

import com.github.javafaker.Faker;
import com.selfimprovement.app.conf.annotation.MapperTestDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static com.selfimprovement.app.utils.generators.DataGenerator.buildPetEntity;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@MapperTestDefinition
@ContextConfiguration(
        classes = PetMapperImpl.class
)
class PetMapperTest {

    @Autowired
    PetMapper petMapper;

    private final Faker faker = Faker.instance();

    @Test
    void testMapToPetDto() {
        var petEntity = buildPetEntity(faker).build();

        var petDto = petMapper.mapToPetDto(petEntity);

        assertThat(petDto.getName()).isEqualTo(petEntity.getName());
    }
}
