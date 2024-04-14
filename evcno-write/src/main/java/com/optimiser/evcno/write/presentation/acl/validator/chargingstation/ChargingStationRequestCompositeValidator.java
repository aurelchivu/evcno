package com.optimiser.evcno.write.presentation.acl.validator.chargingstation;

import org.apache.commons.chain.impl.ChainBase;
import org.springframework.stereotype.Service;

@Service
public class ChargingStationRequestCompositeValidator extends ChainBase {

    public static final String CHARGING_STATION_CREATION_REQUEST = "ChargingStationCreationRequest";

    public ChargingStationRequestCompositeValidator() {
        addCommand(new ChargingStationCreationRequestValidator());
    }
}
