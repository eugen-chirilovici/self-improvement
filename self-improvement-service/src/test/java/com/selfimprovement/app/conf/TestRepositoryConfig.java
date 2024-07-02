package com.selfimprovement.app.conf;

import com.selfimprovement.app.repository.listener.UuidIdentifiedEntityEventListener;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import static com.selfimprovement.app.config.converter.MongoDBCustomConverters.getMongoDbCustomConverters;

@TestConfiguration
public class TestRepositoryConfig {

    @Bean
    public UuidIdentifiedEntityEventListener uuidIdentifiedEntityEventListener() {
        return new UuidIdentifiedEntityEventListener();
    }

    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(getMongoDbCustomConverters());
    }
}