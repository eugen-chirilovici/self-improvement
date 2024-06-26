package com.selfimprovement.app.mapper;

import com.selfimprovement.app.config.MapStructConfig;
import com.selfimprovement.app.server.openapi.model.Data;
import com.selfimprovement.app.server.openapi.model.InitFlowResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        config = MapStructConfig.class
)
public interface InitFlowMapper {

    @Mapping(target = "errorData", ignore = true)
    @Mapping(target = "data", source = "data")
    InitFlowResponse mapToInitFlowResponse(Data data);
}
