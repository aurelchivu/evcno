package com.optimiser.evcno.read.infrastructure.kafka.handler.chargingStation;

import com.optimiser.evcno.published.language.infrastructure.avro.v1.ChargingStationDataAvro;
import com.optimiser.evcno.read.application.DataHandler;
import com.optimiser.evcno.read.presentation.acl.adapter.ChargingStationAdapter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChargingStationHandler implements DataHandler<ChargingStationDataAvro> {

    private final ChargingStationAdapter chargingStationAdapter;

    @Override
    public void handleData(ChargingStationDataAvro data) {
        if (data instanceof ChargingStationDataAvro chargingStationDataAvro) {
            handleData(chargingStationDataAvro);
        }
    }

    @Override
    public void handleObject(Object data) {

    }
}
