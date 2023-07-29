package com.selfimprovement.app.conf;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;


@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@WebFluxTest
/*
useful info:
   1. https://howtodoinjava.com/spring-boot2/testing/webfluxtest-with-webtestclient/
   2. https://medium.com/@BPandey/writing-unit-test-in-reactive-spring-boot-application-32b8878e2f57
   3. https://www.youtube.com/watch?v=RPmTXiw-dHA&ab_channel=SpringDeveloper
 */
public class TestRunnerIT {

    @Autowired
    public WebTestClient webTestClient;

}
