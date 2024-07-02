package com.selfimprovement.app.repository;

import com.github.javafaker.Faker;
import com.selfimprovement.app.conf.mongo.MongoInitializer;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.util.List;

import static com.selfimprovement.app.utils.generators.DataGenerator.buildPetEntity;
import static org.assertj.core.api.Assertions.assertThat;

@Log4j2
public class PetRepositoryTest extends MongoInitializer {

    @Autowired
    private PetRepository petRepository;

    private final Faker faker = Faker.instance();

    @Test
    public void getPets() {
        var petEntity = buildPetEntity(faker).build();
        var petEntity1 = buildPetEntity(faker).build();
        var petEntity2 = buildPetEntity(faker).build();

        StepVerifier.create(petRepository.save(petEntity))
                .assertNext(pet -> {
                    log.info("Result: {}", pet.toString());
                    assertThat(pet.getName()).isEqualTo(petEntity.getName());
                })
                .expectNextCount(0)
                .verifyComplete();

        StepVerifier.create(petRepository.saveAll(List.of(petEntity1, petEntity2)))
                .assertNext(pet -> {
                    log.info("Result: {}", pet.toString());
                    assertThat(pet.getName()).isEqualTo(petEntity1.getName());
                })
                .expectNextCount(1)
                .verifyComplete();

        StepVerifier.create(petRepository.findAll())
                .expectNextCount(2)
                .assertNext(pet -> {
                    log.info("Result: {}", pet.toString());
                    assertThat(pet.getName()).isEqualTo(petEntity2.getName());
                })
                .verifyComplete();
    }
}
