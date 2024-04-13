package com.optimiser.evcno.write.application.service.chargingstation;

import com.optimiser.evcno.write.domain.gateway.ChargingStationCreationGateway;
import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChargingStationCreationGatewayService {

    private final ChargingStationCreationGateway chargingStationCreationGateway;

    public Mono<ChargingStationId> createChargingStation(ChargingStation chargingStation) {

        return chargingStationCreationGateway.createChargingStation(chargingStation);
    }
}
