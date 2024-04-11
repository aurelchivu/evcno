package com.optimiser.evcno.write.domain.model;

import com.optimiser.evcno.write.domain.valueobject.Address;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationStatus;
import com.optimiser.evcno.write.domain.valueobject.StationType;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class ChargingStation implements Serializable {

    private ChargingStationId chargingStationId;
    private Address address;
    private int capacity;
    private int availableChargingPoints;
    private StationType stationType;
    private ChargingStationStatus status;
}
