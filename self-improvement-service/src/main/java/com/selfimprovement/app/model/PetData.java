package com.selfimprovement.app.model;

import com.selfimprovement.app.model.dto.PetDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PetData {
    private List<PetDto> pets;
    private PetDto pet;
}
