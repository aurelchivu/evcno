package com.optimiser.evcno.write.infrastructure.kafka.handler.chargingstation;

import static com.optimiser.evcno.write.infrastructure.kafka.handler.Constants.CONTEXT_EVENT_KEY;
import static com.optimiser.evcno.write.infrastructure.kafka.handler.Constants.DATA_SUPPLIER_OUT_0;

import com.optimiser.evcno.write.domain.event.chargingstation.ChargingStationCreatedEvent;
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

        if (context.get(CONTEXT_EVENT_KEY) instanceof ChargingStationCreatedEvent chargingStationCreatedEvent) {
            outputDataStream(chargingStationCreatedEvent);
        }
        return CONTINUE_PROCESSING;
    }

    private void outputDataStream(ChargingStationCreatedEvent chargingStationCreatedEvent) {
        log.info("Publishing Charging Station Data: {}", chargingStationCreatedEvent.getChargingStationId().getPrimaryId());
        streamBridge.send(DATA_SUPPLIER_OUT_0, chargingStationCreatedEvent.getChargingStationId().getPrimaryId());
    }
}
