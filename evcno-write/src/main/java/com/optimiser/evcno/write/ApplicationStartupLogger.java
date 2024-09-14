package com.optimiser.evcno.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class ApplicationStartupLogger {

    private static final Logger log = LoggerFactory.getLogger(ApplicationStartupLogger.class);

    @Autowired
    private Environment environment;

    @PostConstruct
    public void init() {
        log.info("Kafka Bootstrap Servers: {}", environment.getProperty("spring.kafka.bootstrap-servers"));
        log.info("Kafka Consumer Bootstrap Servers: {}", environment.getProperty("spring.kafka.consumer.bootstrap-servers"));
        log.info("Kafka Producer Bootstrap Servers: {}", environment.getProperty("spring.kafka.producer.bootstrap-servers"));
    }
}

