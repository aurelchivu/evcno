package com.optimiser.evcno.write.infrastructure.axon.gateway.chargingstation;

import com.optimiser.evcno.write.application.command.chargingstation.CreateChargingStationCommand;
import com.optimiser.evcno.write.domain.gateway.ChargingStationCreationGateway;
import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AxonChargingStationCreationGateway implements ChargingStationCreationGateway {

    private final CommandGateway commandGateway;

    @Override
    public Mono<ChargingStationId> createChargingStation(ChargingStation chargingStation) {

        CreateChargingStationCommand command =
                CreateChargingStationCommand.builder()
                        .chargingStation(chargingStation)
                        .chargingStationId(chargingStation.getChargingStationId())
                        .build();

        return Mono.fromFuture(() -> commandGateway.send(command)
                .thenApply(nullResponse -> command.getChargingStation().getChargingStationId()));
    }
}
