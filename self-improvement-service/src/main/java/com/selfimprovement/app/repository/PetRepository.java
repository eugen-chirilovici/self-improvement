package com.selfimprovement.app.repository;

import com.selfimprovement.model.PetEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface PetRepository extends ReactiveMongoRepository<PetEntity, UUID> {
}
