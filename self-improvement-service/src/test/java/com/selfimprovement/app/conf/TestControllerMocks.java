package com.selfimprovement.app.conf;

import com.github.javafaker.Faker;
import com.selfimprovement.app.conf.annotation.RestControllerTestDefinition;
import com.selfimprovement.app.facade.PetFacade;
import com.selfimprovement.app.mapper.InitPetFlowMapper;
import com.selfimprovement.app.mapper.PetMapper;
import com.selfimprovement.app.repository.PetRepository;
import com.selfimprovement.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;


@RestControllerTestDefinition
public abstract class TestControllerMocks {
    protected final Faker faker = Faker.instance();

    @Autowired
    public WebTestClient webTestClient;

    @MockBean
    public PetMapper petMapper;

    @MockBean
    public PetFacade petFacade;

    @MockBean
    public PetService petService;

    @MockBean
    public InitPetFlowMapper initPetFlowMapper;

    @MockBean
    PetRepository petRepository;
}
