/* Evcno (C)2024 */
package com.optimiser.evcno.read;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EntityScan(basePackages = "com.accelerator.ledger.read.infrastructure.db.dbo")
@EnableCaching
public class EvcnoReadApp {

    public static void main(String[] args) {
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(EvcnoReadApp.class, args);
    }
}
