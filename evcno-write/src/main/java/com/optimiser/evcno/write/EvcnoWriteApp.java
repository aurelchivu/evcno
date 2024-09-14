package com.optimiser.evcno.write;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.optimiser.evcno"})
@EnableTransactionManagement
@EntityScan(
        basePackages = {
                "com.accelerator.ledger.domain",
                "org.axonframework.eventhandling.tokenstore",
                "org.axonframework.modelling.saga.repository.jpa",
                "org.axonframework.eventsourcing.eventstore.jpa"
        })
@EnableCaching
public class EvcnoWriteApp {

    public static void main(String[] args) {
        SpringApplication.run(EvcnoWriteApp.class, args);
    }
}
