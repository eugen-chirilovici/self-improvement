package com.selfimprovement.app.service;

import com.selfimprovement.app.service.mapper.PetMapper;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.app.repository.PetRepository;
import com.selfimprovement.model.PetEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PetService {
    private final PetRepository petRepository;
    private final PetMapper petMapper;

    public Mono<PetEntity> save(PetEntity petEntity) {
        return petRepository.save(petEntity);
    }

    public Flux<PetDto> findAll() {
        return petRepository.findAll()
                .map(petMapper::mapToPetDto);
    }
}
