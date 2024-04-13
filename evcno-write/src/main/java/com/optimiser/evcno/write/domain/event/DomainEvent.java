package com.optimiser.evcno.write.domain.event;

import com.optimiser.evcno.write.domain.valueobject.Identifiable;

public interface DomainEvent {

    Identifiable relatedAggregateId();
}
