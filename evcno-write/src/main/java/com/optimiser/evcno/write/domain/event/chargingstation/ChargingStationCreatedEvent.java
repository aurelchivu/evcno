package com.optimiser.evcno.write.domain.event.chargingstation;

import com.optimiser.evcno.write.domain.event.DomainEvent;
import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import com.optimiser.evcno.write.domain.valueobject.Identifiable;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ChargingStationCreatedEvent implements Serializable, DomainEvent {

    private ChargingStation chargingStation;
    private ChargingStationId chargingStationId;

    @Override
    public Identifiable relatedAggregateId() {
        return chargingStationId;
    }
}
