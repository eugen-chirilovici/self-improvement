package com.selfimprovement.app.facade;

import com.selfimprovement.app.mapper.DataMapper;
import com.selfimprovement.app.model.PetData;
import com.selfimprovement.app.model.dto.PetDto;
import com.selfimprovement.app.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PetFacade {
    private final PetService petService;
    private final DataMapper dataMapper;

    public Mono<PetData> findAll() {
        return Mono.from(petService.findAll().buffer())
                .map(dataMapper::mapToPetData);
    }

    public Mono<PetData> save(PetDto pet) {
        return Mono.just(pet)
                .flatMap(petService::save)
                .map(dataMapper::mapPetDtoToPetData);
    }
}
