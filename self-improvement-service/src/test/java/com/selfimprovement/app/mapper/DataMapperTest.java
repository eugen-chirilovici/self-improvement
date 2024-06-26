package com.selfimprovement.app.mapper;

import com.github.javafaker.Faker;
import com.selfimprovement.app.conf.annotation.MapperTestDefinition;
import com.selfimprovement.app.server.openapi.model.Data;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.selfimprovement.app.utils.generators.DataGenerator.buildPet;
import static com.selfimprovement.app.utils.generators.DataGenerator.buildPetDto;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@MapperTestDefinition
@ContextConfiguration(
        classes = DataMapperImpl.class
)
public class DataMapperTest {

    @Autowired
    DataMapper dataMapper;

    private final Faker faker = Faker.instance();

    @Test
    void testMapToInitFlowResponse() {
        var petDto = buildPetDto(faker).build();

        var data = dataMapper.mapToData(List.of(petDto));

        var pet = buildPet(faker, petDto.getName());

        assertThat(data).isNotNull()
                .extracting(Data::getPets)
                .isInstanceOf(List.class)
                .asList().contains(pet);
    }
}
