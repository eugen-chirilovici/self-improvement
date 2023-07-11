package com.selfimprovement.app.repository;

import com.selfimprovement.model.CategoryEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface CategoryRepository extends ReactiveMongoRepository<CategoryEntity, UUID> {

    Flux<CategoryEntity> findAllByName(String name);
}
