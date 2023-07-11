package com.selfimprovement.app.controller;

import com.selfimprovement.app.model.PetDto;
import com.selfimprovement.app.repository.PetRepository;
import com.selfimprovement.model.PetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class AppController {

    private final PetRepository petRepository;

    @PostMapping(value = "/pet")
    public ResponseEntity<HttpStatus> postPet(@RequestBody PetDto petDto) {
        PetEntity petEntity = PetEntity.builder()
                .name(petDto.getName())
                .build();

        Mono.just(petEntity)
                .flatMap(petRepository::save)
                .subscribe();

        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @GetMapping(value = "/pet", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<PetEntity> getPets() {
        return petRepository.findAll();
    }
}
