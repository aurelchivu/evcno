package com.optimiser.evcno.write.infrastructure.axon.kafkapublisher;

import com.optimiser.evcno.write.domain.event.DomainEventPublisher;
import com.optimiser.evcno.write.domain.event.chargingstation.ChargingStationCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AxonChargingStationKafkaPublisher {

    @Autowired
    @Qualifier("kafkaStreamPublisher")
    private DomainEventPublisher kafkaStreamPublisher;

    @EventHandler
    public void on(ChargingStationCreatedEvent event) {
        kafkaStreamPublisher.publishEvent(event);
    }
}
