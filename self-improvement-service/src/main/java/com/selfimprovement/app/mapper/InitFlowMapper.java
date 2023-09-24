package com.selfimprovement.app.mapper;

import com.selfimprovement.app.config.MapStructConfig;
import com.selfimprovement.app.dto.PetDto;
import com.selfimprovement.app.server.openapi.model.Data;
import com.selfimprovement.app.server.openapi.model.InitFlowResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(
        componentModel = "spring",
        config = MapStructConfig.class
)
public interface InitFlowMapper {

    PetMapper petMapper = Mappers.getMapper(PetMapper.class);

    @Mapping(target = "errorData", ignore = true)
    @Mapping(target = "data", source = "data")
    InitFlowResponse mapToInitFlowResponse(Data data);

    default Data mapToData(List<PetDto> pets) {
        return new Data().pet(
                pets.stream()
                        .map(petMapper::mapPetDtoToPetDtoResponse)
                        .toList());
    }
}
