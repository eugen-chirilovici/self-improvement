package com.selfimprovement.app.facade;

import com.selfimprovement.app.mapper.DataMapper;
import com.selfimprovement.app.mapper.PetMapper;
import com.selfimprovement.app.server.openapi.model.Data;
import com.selfimprovement.app.server.openapi.model.Pet;
import com.selfimprovement.app.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PetFacade {
    private final PetService petService;
    private final DataMapper dataMapper;
    private final PetMapper petMapper;

    public Mono<Data> findAll() {
        return Mono.from(petService.findAll().buffer())
                .map(dataMapper::mapToData);
    }

    public Mono<Data> save(Pet pet) {
        return Mono.just(pet)
                .map(petMapper::mapPetDtoRequestToPetDto)
                .flatMap(petService::save)
                .map(dataMapper::mapPetDtoToData);
    }
}
