package com.selfimprovement.app.controller;

import com.selfimprovement.app.conf.TestControllerMocks;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.app.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

public class AppBaseControllerTest extends TestControllerMocks {

    @MockBean
    PetRepository petRepository;

    @Test
    void check_the_endpoint() {
        webTestClient
                .get()
                .uri("/pet")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBodyList(PetDto.class);
    }
}
