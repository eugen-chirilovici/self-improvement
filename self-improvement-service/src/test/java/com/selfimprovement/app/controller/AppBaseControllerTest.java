package com.selfimprovement.app.controller;

import com.selfimprovement.app.conf.TestControllerMocks;
import com.selfimprovement.app.dto.PetDto;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Flux;

import static com.selfimprovement.app.utils.generators.DataGenerator.buildPetDto;
import static com.selfimprovement.app.utils.generators.DataGenerator.buildPetDtoResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Import(AppController.class)
class AppBaseControllerTest extends TestControllerMocks {

    @Test
    void check_getPet_endpoint() {

        var petName = faker.name().name();

        when(petService.findAll())
                .thenReturn(Flux.just(buildPetDto(faker).name(petName).build()));
        when(petMapper.mapPetDtoToPetDtoResponse(any()))
                .thenReturn(buildPetDtoResponse(faker, petName));

        webTestClient
                .get()
                .uri("/pet")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(PetDto.class);
    }
}
