package com.selfimprovement.app.controller;

import com.selfimprovement.app.facade.PetFacade;
import com.selfimprovement.app.mapper.InitFlowMapper;
import com.selfimprovement.app.server.openapi.api.PetsApi;
import com.selfimprovement.app.server.openapi.model.InitFlowResponse;
import com.selfimprovement.app.server.openapi.model.Pet;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
public class AppController implements PetsApi {

    private final PetFacade petFacade;
    private final InitFlowMapper initFlowMapper;

    @Override
    public Mono<ResponseEntity<InitFlowResponse>> getPets(ServerWebExchange exchange) {
        return petFacade.findAll()
                .map(initFlowMapper::mapToInitFlowResponse)
                .map(ResponseEntity::ok)
                .log("Exit get pets endpoint");
    }

    @Override
    public Mono<ResponseEntity<InitFlowResponse>> postPet(Mono<Pet> petDto, ServerWebExchange exchange) {
        return petDto.flatMap(petFacade::save)
                .map(initFlowMapper::mapToInitFlowResponse)
                .map(body -> ResponseEntity.status(HttpStatus.CREATED).body(body))
                .log("Exit post pet endpoint");
    }
}
