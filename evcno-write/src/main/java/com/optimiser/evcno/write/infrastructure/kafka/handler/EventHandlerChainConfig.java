package com.optimiser.evcno.write.infrastructure.kafka.handler;

import com.optimiser.evcno.write.infrastructure.kafka.handler.chargingstation.ChargingStationCreatedEventHandler;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventHandlerChainConfig {

    @Bean
    public EventHandlerChain eventHandlerChain(StreamBridge streamBridge) {

        EventHandlerChain chain = new EventHandlerChain();
        chain.addCommand(new ChargingStationCreatedEventHandler(streamBridge));
        return chain;
    }
}
