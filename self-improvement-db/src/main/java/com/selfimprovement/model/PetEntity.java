package com.selfimprovement.model;

import java.util.List;

import com.selfimprovement.model.enums.PetStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Pet entity DB class model, used to manage Pet records.
 */
@Data
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@EqualsAndHashCode(callSuper = true)
@Document(collection = PetEntity.COLLECTION_NAME)
@AllArgsConstructor(onConstructor = @__(@PersistenceConstructor))
public class PetEntity extends UuidIdentifiedEntity {

    /**
     * Collection name to whom this document is attached.
     */
    public static final String COLLECTION_NAME = "pets";

    private CategoryEntity category;

    private String name;

    private List<String> photoUrls;

    private List<TagDataEntity> tags;

    private PetStatusEnum status;
}
