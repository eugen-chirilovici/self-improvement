package com.selfimprovement.app.mapper;

import com.selfimprovement.app.config.MapStructConfig;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.app.server.openapi.model.Data;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "spring",
        config = MapStructConfig.class
)
public interface DataMapper {

    PetMapper petMapper = Mappers.getMapper(PetMapper.class);

    default Data mapToData(List<PetDto> pets) {
        return new Data().pets(
                pets.stream()
                        .map(petMapper::mapPetDtoToPetDtoResponse)
                        .toList());
    }

    @Mapping(target = "pets", ignore = true)
    @Mapping(target = "pet", expression = "java(petMapper.mapPetDtoToPetDtoResponse(petDto))")
    Data mapPetDtoToData(PetDto petDto);
}
