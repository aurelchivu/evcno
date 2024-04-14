package com.optimiser.evcno.write.presentation.acl.validator.chargingstation;

import static com.optimiser.evcno.write.presentation.acl.validator.chargingstation.ChargingStationRequestCompositeValidator.CHARGING_STATION_CREATION_REQUEST;

import com.optimiser.evcno.write.presentation.dto.request.ChargingStationCreationRequest;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.stereotype.Service;

@Service
public class ChargingStationCreationRequestValidator implements Command {

    @Override
    public boolean execute(Context context) throws Exception {

        ChargingStationCreationRequest chargingStationCreationRequest = extractRequest(context);
        validate(chargingStationCreationRequest);

        return CONTINUE_PROCESSING;
    }

    private ChargingStationCreationRequest extractRequest(final Context context) {

        ChargingStationCreationRequest typeSafeRequest = ChargingStationCreationRequest.builder().build();
        final Object rawRequest = context.get(CHARGING_STATION_CREATION_REQUEST);

        if (rawRequest instanceof ChargingStationCreationRequest request) {
            typeSafeRequest = request;
        }
        return typeSafeRequest;
    }

    public void validate(ChargingStationCreationRequest chargingStationCreationRequest) {
        // Placeholder validation method
    }
}
