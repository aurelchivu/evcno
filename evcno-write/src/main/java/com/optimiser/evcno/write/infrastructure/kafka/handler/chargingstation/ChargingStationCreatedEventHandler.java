package com.optimiser.evcno.write.infrastructure.kafka.handler.chargingstation;

import static com.optimiser.evcno.write.infrastructure.kafka.handler.Constants.CONTEXT_EVENT_KEY;
import static com.optimiser.evcno.write.infrastructure.kafka.handler.Constants.DATA_SUPPLIER_OUT_0;

import com.optimiser.evcno.published.language.infrastructure.avro.v1.ChargingStationDataAvro;
import com.optimiser.evcno.write.domain.event.chargingstation.ChargingStationCreatedEvent;
import com.optimiser.evcno.write.infrastructure.kafka.translator.chargingstationdata.ChargingStationDataTranslator;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;
import org.springframework.cloud.stream.function.StreamBridge;

@Slf4j
@AllArgsConstructor
public class ChargingStationCreatedEventHandler implements Command {

    private final StreamBridge streamBridge;

    @Override
    public boolean execute(Context context) throws Exception {

//        if (context.get(CONTEXT_EVENT_KEY) instanceof ChargingStationCreatedEvent chargingStationCreatedEvent) {
//
//            ChargingStationDataAvro chargingStationDataAvro =
//                    ChargingStationDataTranslator.INSTANCE.mapToChargingStationDataAvro(
//                            chargingStationCreatedEvent.getChargingStation());
//
//            chargingStationDataAvro.setEventType(chargingStationCreatedEvent.getClass().getSimpleName());
//            chargingStationDataAvro.setPackageName(chargingStationCreatedEvent.getClass().getPackageName());
//
//            outputDataStream(chargingStationDataAvro);
//        }

        return CONTINUE_PROCESSING;
    }

    private void outputDataStream(ChargingStationDataAvro chargingStationDataAvro) {
        log.info("Publishing Charging Station Data: {}", chargingStationDataAvro);
        streamBridge.send(DATA_SUPPLIER_OUT_0, chargingStationDataAvro);
    }
}
