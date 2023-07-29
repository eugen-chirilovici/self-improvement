package com.selfimprovement.app.controller;

import com.selfimprovement.app.conf.TestRunnerIT;
import com.selfimprovement.app.model.PetDto;
import com.selfimprovement.app.repository.PetRepository;
import com.selfimprovement.model.PetEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;

import static com.selfimprovement.app.utils.generators.PetGenerator.buildPetDto;
import static org.mockito.Mockito.when;

public class AppControllerIT extends TestRunnerIT {

    @MockBean
    PetRepository petRepository;

    @Test
    void check_the_endpoint() {

        when(petRepository.findAll()).thenReturn(
                Flux.just(
                        PetEntity.builder().name("Betty").build(),
                        PetEntity.builder().name("Nemo").build()));

        webTestClient
                .get()
                .uri("/pet")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(PetDto.class)
                .hasSize(2)
                .contains(
                        buildPetDto("Betty"),
                        buildPetDto("Nemo"));
    }
}
