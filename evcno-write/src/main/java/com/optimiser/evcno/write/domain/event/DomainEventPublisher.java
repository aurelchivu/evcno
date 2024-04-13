package com.optimiser.evcno.write.domain.event;

public interface DomainEventPublisher {

    <T> void publishEvent(final T aDomainEvent);
}
