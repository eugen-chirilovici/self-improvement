package com.selfimprovement.app.controller;

import com.selfimprovement.app.conf.TestControllerMocks;
import com.selfimprovement.app.server.openapi.model.Data;
import com.selfimprovement.app.server.openapi.model.InitFlowResponse;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.Import;
import reactor.core.publisher.Flux;

import static com.selfimprovement.app.utils.generators.DataGenerator.buildInitFlowResponse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@Import(AppController.class)
class AppBaseControllerTest extends TestControllerMocks {

    @Test
    void check_getPet_endpoint() {

        when(petService.findAll()).thenReturn(Flux.just());
        when(initFlowMapper.mapToData(any())).thenReturn(mock(Data.class));
        when(initFlowMapper.mapToInitFlowResponse(any()))
                .thenReturn(buildInitFlowResponse(faker, null));

        webTestClient
                .get()
                .uri("/pet")
                .exchange()
                .expectStatus().is2xxSuccessful()
                .expectBody(InitFlowResponse.class);
    }
}
