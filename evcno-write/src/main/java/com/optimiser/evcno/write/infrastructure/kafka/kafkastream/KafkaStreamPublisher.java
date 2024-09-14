package com.optimiser.evcno.write.infrastructure.kafka.kafkastream;

import static com.optimiser.evcno.write.infrastructure.kafka.handler.Constants.CONTEXT_EVENT_KEY;

import com.optimiser.evcno.write.domain.event.DomainEventPublisher;
import com.optimiser.evcno.write.infrastructure.kafka.handler.EventHandlerChain;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class KafkaStreamPublisher implements DomainEventPublisher {

    private static final String ERROR_PROCESSING_EVENT_MESSAGE = "Error processing event";
    private final EventHandlerChain eventHandlerChain;

    @Override
    @SuppressWarnings("unchecked")
    public <T> void publishEvent(T aDomainEvent) {

        Context context = new ContextBase();
        context.put(CONTEXT_EVENT_KEY, aDomainEvent);
        try {
            eventHandlerChain.execute(context);
        } catch (Exception e) {
            log.error(ERROR_PROCESSING_EVENT_MESSAGE, e);
        }
    }
}
