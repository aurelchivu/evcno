package com.optimiser.evcno.write.domain.model;

import com.optimiser.evcno.write.domain.event.DomainEventPublisher;
import com.optimiser.evcno.write.domain.event.chargingstation.ChargingStationCreatedEvent;
import com.optimiser.evcno.write.domain.valueobject.Address;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationStatus;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class ChargingStation implements Serializable {

    private ChargingStationId chargingStationId;
    private String name;
    private Address address;
    private int capacity;
    private int availableChargingPoints;
    private ChargingStationType chargingStationType;
    private ChargingStationStatus chargingStationStatus;

    public void publishChargingStationCreatedEvent(DomainEventPublisher domainEventPublisher) {

        ChargingStationCreatedEvent event = new ChargingStationCreatedEvent(this, getChargingStationId());
        domainEventPublisher.publishEvent(event);
    }

    public void on(ChargingStationCreatedEvent event) {
        // TODO Implement this
    }
}
