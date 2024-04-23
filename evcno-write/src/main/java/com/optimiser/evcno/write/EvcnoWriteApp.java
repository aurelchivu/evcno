package com.optimiser.evcno.write;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.optimiser.evcno"})
public class EvcnoWriteApp {
    public static void main(String[] args) {
        SpringApplication.run(EvcnoWriteApp.class, args);
    }
}
