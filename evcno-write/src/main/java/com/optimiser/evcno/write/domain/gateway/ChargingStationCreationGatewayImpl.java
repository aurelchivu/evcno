package com.optimiser.evcno.write.domain.gateway;

import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ChargingStationCreationGatewayImpl implements ChargingStationCreationGateway {

    @Override
    public Mono<ChargingStationId> createChargingStation(ChargingStation chargingStation) {
        return Mono.just(new ChargingStationId());
    }
}
