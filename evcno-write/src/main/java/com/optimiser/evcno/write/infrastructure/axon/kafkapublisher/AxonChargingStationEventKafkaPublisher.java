package com.optimiser.evcno.write.infrastructure.axon.kafkapublisher;

import com.optimiser.evcno.write.domain.event.DomainEventPublisher;
import com.optimiser.evcno.write.domain.event.chargingstation.ChargingStationCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AxonChargingStationEventKafkaPublisher {

    @Autowired
    @Qualifier("kafkaStreamPublisher")
    private final DomainEventPublisher kafkaStreamPublisher;

    @EventHandler
    public void on(ChargingStationCreatedEvent event) {
        kafkaStreamPublisher.publishEvent(event);
    }
}
