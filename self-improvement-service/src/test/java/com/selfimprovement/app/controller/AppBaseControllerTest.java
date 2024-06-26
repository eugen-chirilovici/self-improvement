package com.selfimprovement.app.controller;

import com.selfimprovement.app.conf.TestControllerMocks;
import com.selfimprovement.app.server.openapi.model.InitFlowResponse;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Mono;

import static com.selfimprovement.app.utils.generators.DataGenerator.buildInitFlowResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Import(AppController.class)
class AppBaseControllerTest extends TestControllerMocks {

    @Test
    void check_getPet_endpoint() {

        when(petFacade.findAll()).thenReturn(Mono.empty());
        when(initFlowMapper.mapToInitFlowResponse(any()))
                .thenReturn(buildInitFlowResponse(faker, null));

        webTestClient
                .get()
                .uri("/pets")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(InitFlowResponse.class);
    }
}
