package com.selfimprovement.model;

import java.util.UUID;
import lombok.Data;

/**
 * Category entity DB class model, used to store linked tag to: {{{@link PetEntity}}}.
 */
@Data
public class TagDataEntity {

    private UUID id;
    private String name;
}
