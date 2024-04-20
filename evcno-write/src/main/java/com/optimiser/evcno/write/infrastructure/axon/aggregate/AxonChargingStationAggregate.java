package com.optimiser.evcno.write.infrastructure.axon.aggregate;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

import com.optimiser.evcno.write.application.command.CommandPublisher;
import com.optimiser.evcno.write.application.command.chargingstation.CreateChargingStationCommand;
import com.optimiser.evcno.write.domain.event.DomainEventPublisher;
import com.optimiser.evcno.write.domain.event.chargingstation.ChargingStationCreatedEvent;
import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateCreationPolicy;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.CreationPolicy;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Aggregate(snapshotTriggerDefinition = "chargingStationSnapshotTriggerDefinition")
public class AxonChargingStationAggregate implements CommandPublisher, DomainEventPublisher, Serializable {

    @AggregateIdentifier private ChargingStationId chargingStationId;

    private ChargingStation chargingStation;

    @Autowired private transient CommandGateway commandGateway;

    @CommandHandler
    @CreationPolicy(AggregateCreationPolicy.CREATE_IF_MISSING)
    public void handle(CreateChargingStationCommand command) {
        if (chargingStation == null) {
            command.getChargingStation().publishChargingStationCreatedEvent(this);
        }
    }

    @EventSourcingHandler
    public void on(ChargingStationCreatedEvent event) {

        chargingStation = defaultIfNull(chargingStation, event.getChargingStation());
        chargingStationId = defaultIfNull(chargingStationId, event.getChargingStationId());
        chargingStation.on(event);
    }

    @Override
    public <T> void publishCommand(T aDomainCommand) {
        commandGateway.send(aDomainCommand);
    }

    @Override
    public <T> void publishEvent(T aDomainEvent) {
        apply(aDomainEvent);
    }
}
