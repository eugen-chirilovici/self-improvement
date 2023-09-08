package com.selfimprovement.app.controller;

import com.selfimprovement.app.conf.TestControllerMocks;
import com.selfimprovement.app.dto.PetDto;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;

@Import(AppController.class)
class AppBaseControllerTest extends TestControllerMocks {

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
