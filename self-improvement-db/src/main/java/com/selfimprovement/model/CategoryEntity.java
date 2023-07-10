package com.selfimprovement.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Category entity DB class model, used to manage Category records.
 */

@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = CategoryEntity.COLLECTION_NAME)
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class CategoryEntity extends UuidIdentifiedEntity {

    /**
     * Collection name to whom this document is attached.
     */
    public static final String COLLECTION_NAME = "categories";

    private String name;
}
