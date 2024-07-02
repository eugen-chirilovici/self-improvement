package com.selfimprovement.app.conf.mongo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public interface MongoTestContainer {
    Logger log = LoggerFactory.getLogger(MongoTestContainer.class);

    String TEST_USER = "test_user";
    String TEST_PWD = "test_pwd";
    String TEST_DB = "test_db";

    int PORT = 27017;
    String MONGO_DOCKER_NAME_WITH_VERSION = "mongo:7.0";
    String MONGO_INITDB_ROOT_USERNAME_ENV_KEY = "MONGO_INITDB_ROOT_USERNAME";
    String MONGO_INITDB_ROOT_PASSWORD_ENV_KEY = "MONGO_INITDB_ROOT_PASSWORD";
    String MONGO_INITDB_DATABASE_ENV_KEY = "MONGO_INITDB_DATABASE";
    String SPRING_DATA_MONGODB_URI_CONFIG_KEY = "spring.data.mongodb.uri";
    String MONGO_URI_TEMPLATE = "mongodb://%s:%s@localhost:%d/%s?authSource=admin";

    @Container
    @ServiceConnection
    GenericContainer<?> mongoDBContainer =
            new GenericContainer<>(DockerImageName.parse(MONGO_DOCKER_NAME_WITH_VERSION))
                    .withExposedPorts(PORT)
                    .withEnv(MONGO_INITDB_ROOT_USERNAME_ENV_KEY, TEST_USER)
                    .withEnv(MONGO_INITDB_ROOT_PASSWORD_ENV_KEY, TEST_PWD)
                    .withEnv(MONGO_INITDB_DATABASE_ENV_KEY, TEST_DB);

    @DynamicPropertySource
    static void registerProperties(DynamicPropertyRegistry registry) {
        registry.add(
                SPRING_DATA_MONGODB_URI_CONFIG_KEY,
                () -> {
                    var uri = MONGO_URI_TEMPLATE.formatted(
                            mongoDBContainer.getEnvMap().get(MONGO_INITDB_ROOT_USERNAME_ENV_KEY),
                            mongoDBContainer.getEnvMap().get(MONGO_INITDB_ROOT_PASSWORD_ENV_KEY),
                            mongoDBContainer.getMappedPort(PORT),
                            mongoDBContainer.getEnvMap().get(MONGO_INITDB_DATABASE_ENV_KEY));
                    log.info("Using MongoDB URI: {}", uri);
                    return uri;
                }
        );
    }
}
