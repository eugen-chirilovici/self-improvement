package com.selfimprovement.app.mapper;

import com.selfimprovement.app.config.MapStructConfig;
import com.selfimprovement.app.model.InitPetFlowResponse;
import com.selfimprovement.app.model.PetData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        config = MapStructConfig.class
)
public interface InitPetFlowMapper {

    @Mapping(target = "errorData", ignore = true)
    @Mapping(target = "data", source = "data")
    InitPetFlowResponse mapToInitFlowResponse(PetData data);
}
