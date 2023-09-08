package com.selfimprovement.app.conf;

import com.selfimprovement.app.conf.annotation.RestControllerTestDefinition;
import com.selfimprovement.app.mapper.PetMapper;
import com.selfimprovement.app.repository.PetRepository;
import com.selfimprovement.app.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;


/*
useful info:
   1. https://howtodoinjava.com/spring-boot2/testing/webfluxtest-with-webtestclient/
   2. https://medium.com/@BPandey/writing-unit-test-in-reactive-spring-boot-application-32b8878e2f57
   3. https://www.youtube.com/watch?v=RPmTXiw-dHA&ab_channel=SpringDeveloper
 */
@RestControllerTestDefinition
public abstract class TestControllerMocks {

    @Autowired
    public WebTestClient webTestClient;

    @MockBean
    public PetMapper petMapper;

    @MockBean
    public PetService petService;

    @MockBean
    PetRepository petRepository;
}
