package com.optimiser.evcno.write.domain.valueobject;

public class ChargingStationId implements Identifiable {

    String primaryId;

    @Override
    public String getPrimaryId() {
        return primaryId;
    }
}
