package com.selfimprovement.app.mapper;

import com.selfimprovement.app.config.MapStructConfig;
import com.selfimprovement.app.model.PetData;
import com.selfimprovement.app.model.dto.PetDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(
        componentModel = "spring",
        config = MapStructConfig.class
)
public interface DataMapper {

    default PetData mapToPetData(List<PetDto> pets) {
        return PetData.builder()
                .pets(pets)
                .build();
    }

    @Mapping(target = "pets", ignore = true)
    @Mapping(target = "pet", source = "petDto")
    PetData mapPetDtoToPetData(PetDto petDto);
}
