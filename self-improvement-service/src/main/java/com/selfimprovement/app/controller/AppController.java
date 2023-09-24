package com.selfimprovement.app.controller;

import com.selfimprovement.app.mapper.InitFlowMapper;
import com.selfimprovement.app.mapper.PetMapper;
import com.selfimprovement.app.server.openapi.api.PetApi;
import com.selfimprovement.app.server.openapi.model.InitFlowResponse;
import com.selfimprovement.app.server.openapi.model.Pet;
import com.selfimprovement.app.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
public class AppController implements PetApi {

    private final PetService petService;
    private final PetMapper petMapper;
    private final InitFlowMapper initFlowMapper;

    @Override
    public Mono<ResponseEntity<InitFlowResponse>> getPets(ServerWebExchange exchange) {
        return Mono.from(petService.findAll().buffer())
                .map(initFlowMapper::mapToData)
                .map(initFlowMapper::mapToInitFlowResponse)
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<String>> postPet(Mono<Pet> petDto, ServerWebExchange exchange) {
        return petDto.map(petMapper::mapPetDtoRequestToPetDto)
                .flatMap(petService::save)
                .map(petMapper::mapPetDtoToPetDtoResponse)
                .map(body -> ResponseEntity.status(HttpStatus.CREATED).body(body.getName()));
    }
}
