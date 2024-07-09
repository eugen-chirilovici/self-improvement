package com.selfimprovement.app.service;

import com.selfimprovement.app.mapper.PetMapper;
import com.selfimprovement.app.model.dto.PetDto;
import com.selfimprovement.app.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public Mono<PetDto> save(PetDto petDto) {
        return Mono.just(petDto)
                .map(petMapper::mapToPetEntity)
                .flatMap(petRepository::save)
                .map(petMapper::mapToPetDto);
    }

    public Flux<PetDto> findAll() {
        return petRepository.findAll()
                .map(petMapper::mapToPetDto);
    }
}
