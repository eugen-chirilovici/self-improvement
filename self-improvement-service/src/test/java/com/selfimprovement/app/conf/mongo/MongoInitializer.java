package com.selfimprovement.app.conf.mongo;

import com.selfimprovement.app.conf.TestRepositoryConfig;
import com.selfimprovement.app.conf.annotation.MapperTestDefinition;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.testcontainers.context.ImportTestcontainers;
import org.springframework.context.annotation.Import;


@MapperTestDefinition
@DataMongoTest
@Import(TestRepositoryConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ImportTestcontainers(MongoTestContainer.class)
public abstract class MongoInitializer {

}
