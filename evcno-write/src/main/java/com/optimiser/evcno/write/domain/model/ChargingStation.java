package com.optimiser.evcno.write.domain.model;

import com.optimiser.evcno.write.domain.valueobject.Address;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationStatus;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationType;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.io.Serializable;

@Builder
@AllArgsConstructor
public class ChargingStation implements Serializable {

    private ChargingStationId chargingStationId;
    private String name;
    private Address address;
    private int capacity;
    private int availableChargingPoints;
    private ChargingStationType chargingStationType;
    private ChargingStationStatus chargingStationStatus;
}
