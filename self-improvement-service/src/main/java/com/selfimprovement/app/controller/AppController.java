package com.selfimprovement.app.controller;

import com.selfimprovement.app.mapper.PetMapper;
import com.selfimprovement.app.server.openapi.api.PetApi;
import com.selfimprovement.app.server.openapi.model.PetDto;
import com.selfimprovement.app.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
public class AppController implements PetApi {

    private final PetService petService;
    private final PetMapper petMapper;

    @Override
    public Mono<ResponseEntity<Flux<PetDto>>> getPets(ServerWebExchange exchange) {
        return Mono.just(
                        petService.findAll()
                                .map(petMapper::mapPetDtoToPetDtoResponse))
                .map(ResponseEntity::ok);
    }

    @Override
    public Mono<ResponseEntity<String>> postPet(Mono<PetDto> petDto, ServerWebExchange exchange) {
        return petDto.map(petMapper::mapPetDtoRequestToPetDto)
                .flatMap(petService::save)
                .map(body -> ResponseEntity.status(HttpStatus.CREATED).body(body.getName()));
    }
}
