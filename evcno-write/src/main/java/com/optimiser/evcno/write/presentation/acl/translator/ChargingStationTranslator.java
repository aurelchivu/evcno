package com.optimiser.evcno.write.presentation.acl.translator;

import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.Address;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationStatus;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationType;
import com.optimiser.evcno.write.presentation.dto.request.ChargingStationCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChargingStationTranslator {

    public ChargingStation toChargingStation(ChargingStationCreationRequest chargingStationCreationRequest) {

        return ChargingStation.builder()
                .chargingStationId(new ChargingStationId())
                .name(chargingStationCreationRequest.getName())
                .address(new Address())
                .capacity(chargingStationCreationRequest.getCapacity())
                .availableChargingPoints(chargingStationCreationRequest.getAvailableChargingPoints())
                .chargingStationType(ChargingStationType.valueOf(
                        chargingStationCreationRequest.getChargingStationType()))
                .chargingStationStatus(ChargingStationStatus.valueOf(
                        chargingStationCreationRequest.getChargingStationStatus()))
                .build();
    }
}
