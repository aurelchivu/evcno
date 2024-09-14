/* Evcno (C)2024 */
package com.optimiser.evcno.read.infrastructure.kafka;

import com.optimiser.evcno.published.language.infrastructure.avro.v1.ChargingStationDataAvro;
import com.optimiser.evcno.read.application.BaseDataHandler;
import java.util.Map;
import java.util.function.Consumer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaStreamListener {

    private static final String EVENT_FIRED = "Event Fired: {}";
    private final Map<String, BaseDataHandler> eventHandlerMap;

    @Bean
    Consumer<Object> processInputData() {
        return input -> {
            try {
                log.info("[DATA-RECEIVED]: {}", input);
                BaseDataHandler baseDataHandler =
                        eventHandlerMap.getOrDefault(
                                determineEventType(input), this::handleUnsupportedEventType);
                baseDataHandler.handleObject(input);
            } catch (Exception e) {
                log.error("Error processing message: {}", input, e);
            }
        };
    }

    private String determineEventType(Object data) {

        if (data instanceof ChargingStationDataAvro chargingStationDataAvro) {
            log.info(EVENT_FIRED, chargingStationDataAvro.getEventType());
            return extractEventTypeAndPackageName(chargingStationDataAvro);
        } else {
            throw new IllegalArgumentException(
                    "Unsupported data type: " + data.getClass().getName());
        }
    }

    private String extractEventTypeAndPackageName(ChargingStationDataAvro input) {
        return input.getEventType().toString().concat(" " + input.getPackageName().toString());
    }

    private void handleUnsupportedEventType(Object data) {
        log.warn("Unsupported event type: {}", data.getClass().getSimpleName());
    }
}
