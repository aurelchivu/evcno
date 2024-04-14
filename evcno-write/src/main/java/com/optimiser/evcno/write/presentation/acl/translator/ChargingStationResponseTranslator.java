package com.optimiser.evcno.write.presentation.acl.translator;

import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import com.optimiser.evcno.write.presentation.dto.response.ChargingStationCreationResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Component
public class ChargingStationResponseTranslator {

    public Mono<ChargingStationCreationResponse> toChargingStationCreationResponse(Mono<ChargingStationId> chargingStationIdMono) {
        return chargingStationIdMono.map(toResponseWithId());
    }

    private Function<ChargingStationId, ChargingStationCreationResponse> toResponseWithId() {
        return id ->
                ChargingStationCreationResponse.builder()
                        .chargingStationId(id.getPrimaryId())
                        .build();
    }
}
