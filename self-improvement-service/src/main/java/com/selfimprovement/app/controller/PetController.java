package com.selfimprovement.app.controller;

import com.selfimprovement.app.facade.PetFacade;
import com.selfimprovement.app.mapper.InitPetFlowMapper;
import com.selfimprovement.app.model.InitPetFlowResponse;
import com.selfimprovement.app.model.dto.PetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;


@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetFacade petFacade;
    private final InitPetFlowMapper initPetFlowMapper;

    @Operation(
            summary = "Get Pets endpoint",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Get all pets"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ups, something bad happen!"
                    )
            }
    )
    @GetMapping(value = "/pets", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<InitPetFlowResponse> getPets() {
        return petFacade.findAll()
                .map(initPetFlowMapper::mapToInitFlowResponse)
                .log("Exit get pets endpoint");
    }

    @Operation(
            summary = "Post Pets endpoint",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created with success"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Ups, something bad happen!"
                    )
            }
    )
    @PostMapping(value = "/pets", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Mono<InitPetFlowResponse> postPet(Mono<PetDto> petDto) {
        return petDto.flatMap(petFacade::save)
                .map(initPetFlowMapper::mapToInitFlowResponse)
                .log("Exit post pet endpoint");
    }
}
