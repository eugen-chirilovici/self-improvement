package com.selfimprovement.app.config;


import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.connection.ConnectionPoolSettings;
import com.selfimprovement.app.repository.listener.UuidIdentifiedEntityEventListener;
import org.bson.UuidRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.selfimprovement.app.config.converter.MongoDBCustomConverters.getMongoDbCustomConverters;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.maxIdleTimeMin}")
    private Long maxIdleTimeMin;

    @Value("${spring.data.mongodb.minSize}")
    private Integer minSize;

    @Value("${spring.data.mongodb.maxSize}")
    private Integer maxSize;

    @Value("${spring.data.mongodb.username}")
    private String username;

    @Value("${spring.data.mongodb.password}")
    private String password;

    @Value("${spring.data.mongodb.database}")
    private String database;

    @Value("${spring.data.mongodb.host}")
    private String host;

    /**
     * List of custom conversions used for Mongodb.
     */
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(getMongoDbCustomConverters());
    }

    @Bean
    public UuidIdentifiedEntityEventListener uuidIdentifiedEntityEventListener() {
        return new UuidIdentifiedEntityEventListener();
    }

    @Bean
    @Primary
    MongoClientSettings mongoDBClientSettings() {
        return MongoClientSettings.builder()
                .retryWrites(false)
                .applyToConnectionPoolSettings((ConnectionPoolSettings.Builder builder) -> builder
                        .maxSize(maxSize)
                        .minSize(minSize)
                        .maxConnectionIdleTime(maxIdleTimeMin, TimeUnit.MINUTES))
                .uuidRepresentation(UuidRepresentation.STANDARD)
                .credential(MongoCredential.createScramSha1Credential(username, database, password.toCharArray()))
                .applyToClusterSettings(builder -> builder.hosts(List.of(new ServerAddress(host))))
                .build();
    }
}
