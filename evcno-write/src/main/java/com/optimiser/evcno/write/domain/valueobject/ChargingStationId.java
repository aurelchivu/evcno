package com.optimiser.evcno.write.domain.valueobject;

import lombok.Value;
import org.apache.tomcat.util.buf.StringUtils;

import java.util.UUID;

@Value
public class ChargingStationId implements Identifiable {

    String primaryId;

    public ChargingStationId() {
        this.primaryId = UUID.randomUUID().toString();
    }

    @Override
    public String getPrimaryId() {
        return primaryId;
    }
}
