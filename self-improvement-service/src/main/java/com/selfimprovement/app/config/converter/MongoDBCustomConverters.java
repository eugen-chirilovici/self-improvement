package com.selfimprovement.app.config.converter;

import lombok.RequiredArgsConstructor;
import lombok.experimental.UtilityClass;
import org.bson.types.Binary;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Custom Mongo DB Service {@link Converter}s, that will enrich existing collection with additional items.
 */
@UtilityClass
public class MongoDBCustomConverters {

    /**
     * Mongo DB default Time zone id value.
     */
    private static final ZoneOffset DEFAULT_TIME_ZONE = ZoneOffset.UTC;

    /**
     * Define all service supported MongoDB custom converters.
     *
     * @return a collection of Spring Data MongoDB {@link Converter}
     */
    public static List<Converter<? extends Serializable, ? extends Serializable>> getMongoDbCustomConverters() {
        return List.of(
                DateToOffsetDateTimeConverter.of(),
                OffsetDateTimeToDateConverter.of(),
                LocalDateToStringConverter.of(),
                BinaryToUuidConverter.of(),
                UuidToBinaryConverter.of()
        );
    }

    /**
     * Converter class to transform object from {@link Date} to {@link OffsetDateTime}.
     */
    @RequiredArgsConstructor(staticName = "of")
    public static class DateToOffsetDateTimeConverter implements Converter<Date, OffsetDateTime> {

        @Override
        public OffsetDateTime convert(@NonNull Date source) {
            return source.toInstant().atOffset(DEFAULT_TIME_ZONE);
        }
    }

    /**
     * Converter class to transform object from {@link LocalDate} to {@link String}.
     */
    @RequiredArgsConstructor(staticName = "of")
    public static class LocalDateToStringConverter implements Converter<LocalDate, String> {

        @Override
        public String convert(@NonNull LocalDate source) {
            return source.toString();
        }
    }

    /**
     * Converter class to transform object from {@link OffsetDateTime} to {@link Date}.
     */
    @RequiredArgsConstructor(staticName = "of")
    public static class OffsetDateTimeToDateConverter implements Converter<OffsetDateTime, Date> {

        @Override
        public Date convert(@NonNull OffsetDateTime source) {
            return Date.from(source.withOffsetSameInstant(DEFAULT_TIME_ZONE).toInstant());
        }
    }

    @RequiredArgsConstructor(staticName = "of")
    public static class BinaryToUuidConverter implements Converter<Binary, UUID> {
        @Override
        public UUID convert(@NonNull Binary binary) {
            ByteBuffer byteBuffer = ByteBuffer.wrap(binary.getData());
            long high = byteBuffer.getLong();
            long low = byteBuffer.getLong();
            return new UUID(high, low);
        }
    }

    @RequiredArgsConstructor(staticName = "of")
    public static class UuidToBinaryConverter implements Converter<UUID, Binary> {
        @Override
        public Binary convert(@NonNull UUID uuid) {
            ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
            bb.putLong(uuid.getMostSignificantBits());
            bb.putLong(uuid.getLeastSignificantBits());
            return new Binary(bb.array());
        }
    }
}
