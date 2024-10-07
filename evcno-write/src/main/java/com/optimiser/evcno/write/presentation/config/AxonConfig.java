package com.optimiser.evcno.write.presentation.config;

import org.axonframework.common.jdbc.PersistenceExceptionResolver;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.EventCountSnapshotTriggerDefinition;
import org.axonframework.eventsourcing.SnapshotTriggerDefinition;
import org.axonframework.eventsourcing.Snapshotter;
import org.axonframework.eventsourcing.eventstore.EmbeddedEventStore;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.axonframework.serialization.Serializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AxonConfig {

    /**
     * Creates an embedded event store using the given storage engine.
     *
     * @param storageEngine the event storage engine to use.
     * @return the embedded event store.
     */
    @Bean
    public EmbeddedEventStore eventStore(EventStorageEngine storageEngine) {
        return EmbeddedEventStore.builder().storageEngine(storageEngine).build();
    }

    /**
     * Configures and provides the JPA-based event storage engine.
     *
     * @param defaultSerializer the default serializer.
     * @param persistenceExceptionResolver exception resolver for persistence.
     * @param eventSerializer serializer for events.
     * @param entityManagerProvider JPA entity manager provider.
     * @param transactionManager transaction manager.
     * @return the JPA event storage engine.
     */
    @Bean
    public EventStorageEngine storageEngine(
            Serializer defaultSerializer,
            PersistenceExceptionResolver persistenceExceptionResolver,
            @Qualifier("eventSerializer") Serializer eventSerializer,
            EntityManagerProvider entityManagerProvider,
            TransactionManager transactionManager) {
        return JpaEventStorageEngine.builder()
                .snapshotSerializer(defaultSerializer)
                .persistenceExceptionResolver(persistenceExceptionResolver)
                .eventSerializer(eventSerializer)
                .entityManagerProvider(entityManagerProvider)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean
    public SnapshotTriggerDefinition chargingStationSnapshotTriggerDefinition(
            Snapshotter snapshotter,
            @Value("${axon.aggregate.snapshot.threshold:10}") int threshold) {
        return new EventCountSnapshotTriggerDefinition(snapshotter, threshold);
    }
}
