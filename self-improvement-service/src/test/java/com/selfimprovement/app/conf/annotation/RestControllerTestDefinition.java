package com.selfimprovement.app.conf.annotation;

import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@BaseTestDefinition
@WebFluxTest
public @interface RestControllerTestDefinition {

}
