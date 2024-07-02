package com.selfimprovement.model;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

/**
 * Document base class used to define ID field.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public abstract class UuidIdentifiedEntity {

    @Id
    private UUID id;

    /**
     * Setter method for id field, has in scope to check value before set. In case value already exist, throw exception.
     *
     * @param id value to be set
     */
    public void setId(UUID id) {

        if (this.id != null) {
            throw new IllegalStateException("Field ID value is already defined, skip value assignment.");
        }

        this.id = id;
    }

    @Version
    private Integer version;
}
