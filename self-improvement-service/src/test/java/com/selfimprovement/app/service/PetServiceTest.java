package com.selfimprovement.app.service;

import com.github.javafaker.Faker;
import com.selfimprovement.app.conf.annotation.MockTestDefinition;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.app.mapper.PetMapper;
import com.selfimprovement.app.repository.PetRepository;
import com.selfimprovement.model.PetEntity;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MockTestDefinition
class PetServiceTest {

    @Mock
    PetRepository petRepository;

    @Mock
    PetMapper petMapper;

    @InjectMocks
    PetService petService;

    private final Faker faker = Faker.instance();

    @Test
    void testFindAll() {

        var petDto = PetDto.builder().name(faker.name().name()).build();

        when(petRepository.findAll()).thenReturn(Flux.just(mock(PetEntity.class)));
        when(petMapper.mapToPetDto(any())).thenReturn(petDto);

        StepVerifier
                .create(petService.findAll())
                .consumeNextWith(res -> assertThat(res).isEqualTo(petDto))
                .verifyComplete();
    }
}
