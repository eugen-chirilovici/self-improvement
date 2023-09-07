package com.selfimprovement.app.service.mapper;

import com.selfimprovement.app.config.MapStructConfig;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.model.PetEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", config = MapStructConfig.class)
public interface PetMapper {

    @Mapping(target = "name", source = "name")
    PetDto mapToPetDto(PetEntity petEntity);
}
