package com.selfimprovement.app.conf.mongo;

import com.selfimprovement.app.conf.TestRepositoryConfig;
import com.selfimprovement.app.conf.annotation.MapperTestDefinition;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.context.annotation.Import;


@Log4j2
@MapperTestDefinition
@DataMongoTest
@Import(TestRepositoryConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ImportTestcontainers(MongoTestContainer.class)
public abstract class MongoInitializer {

}
