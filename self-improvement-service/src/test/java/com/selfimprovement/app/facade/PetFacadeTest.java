package com.selfimprovement.app.facade;

import com.selfimprovement.app.conf.annotation.MockTestDefinition;
import com.selfimprovement.app.mapper.DataMapper;
import com.selfimprovement.app.model.PetData;
import com.selfimprovement.app.model.dto.PetDto;
import com.selfimprovement.app.service.PetService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MockTestDefinition
public class PetFacadeTest {

    @Mock
    PetService petService;

    @Mock
    DataMapper dataMapper;

    @InjectMocks
    PetFacade petFacade;

    @Test
    public void testFindAll() {

        when(petService.findAll()).thenReturn(Flux.just(mock(PetDto.class)));
        when(dataMapper.mapToPetData(anyList())).thenReturn(mock(PetData.class));

        StepVerifier
                .create(petFacade.findAll())
                .consumeNextWith(res -> assertThat(res).isNotNull())
                .verifyComplete();
    }
}
