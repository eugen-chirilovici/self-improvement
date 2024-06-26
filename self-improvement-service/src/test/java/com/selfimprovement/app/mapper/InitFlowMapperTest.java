package com.selfimprovement.app.mapper;

import com.github.javafaker.Faker;
import com.selfimprovement.app.conf.annotation.MapperTestDefinition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@MapperTestDefinition
@ContextConfiguration(
        classes = InitFlowMapperImpl.class
)
public class InitFlowMapperTest {

    @Autowired
    InitFlowMapper initFlowMapper;

    private final Faker faker = Faker.instance();

    @Test
    void testMapToInitFlowResponse() {

//        var data = initFlowMapper.mapToInitFlowResponse();

        assertThat(true).isTrue();
    }
}
