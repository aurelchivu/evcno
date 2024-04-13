package com.optimiser.evcno.write.domain.gateway;

import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;

import reactor.core.publisher.Mono;

public interface ChargingStationCreationGateway {

    Mono<ChargingStationId> createChargingStation(ChargingStation chargingStation);
}
