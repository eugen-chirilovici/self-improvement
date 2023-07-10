package com.selfimprovement.model.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * Pet Status enumeration DB class model, used to manage define Pet status records.
 */
@Getter
@ToString
public enum PetStatusEnum {
    AVAILABLE("available"),
    PENDING("pending"),
    SOLD("sold");

    private final String status;

    PetStatusEnum(String status) {
        this.status = status;
    }
}
