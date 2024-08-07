package com.selfimprovement.app.mapper;

import com.selfimprovement.app.config.MapStructConfig;
import com.selfimprovement.app.model.dto.PetDto;
import com.selfimprovement.model.PetEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        config = MapStructConfig.class
)
public interface PetMapper {

    @InheritInverseConfiguration
    PetDto mapToPetDto(PetEntity petEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "version", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "photoUrls", ignore = true)
    @Mapping(target = "tags", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "name", source = "name")
    PetEntity mapToPetEntity(PetDto petDto);
}
