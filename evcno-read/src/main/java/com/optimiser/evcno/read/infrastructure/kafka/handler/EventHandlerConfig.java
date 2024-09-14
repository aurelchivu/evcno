package com.optimiser.evcno.read.infrastructure.kafka.handler;

import com.optimiser.evcno.read.application.BaseDataHandler;
import com.optimiser.evcno.read.infrastructure.kafka.handler.chargingStation.ChargingStationHandler;
import com.optimiser.evcno.read.presentation.acl.adapter.ChargingStationAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EventHandlerConfig {

    private static final String DOMAIN_EVENT_CHARGINGSTATION =
            " com.optimiser.evcno.write.domain.event.chargingstation";

    private static final String CHARGINGSTATION_CREATED_EVENT_KEY =
            "ChargingStationCreatedEvent" + DOMAIN_EVENT_CHARGINGSTATION;

    @Bean
    public Map<String, BaseDataHandler> eventHandlers(
            ChargingStationAdapter chargingStationAdapter) {

        Map<String, BaseDataHandler> handlers = new HashMap<>();

        handlers.put(CHARGINGSTATION_CREATED_EVENT_KEY, new ChargingStationHandler(chargingStationAdapter));
        return handlers;
    }
}
