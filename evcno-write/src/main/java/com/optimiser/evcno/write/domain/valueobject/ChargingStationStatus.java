package com.optimiser.evcno.write.domain.valueobject;

import java.util.HashMap;
import java.util.Map;

public enum ChargingStationStatus {

    OPERATIONAL(0L, "operational"),
    MAINTENANCE(1L, "maintenance");

    private final Long code;
    private final String description;
    private static final String UNSUPPORTED_STATUS_MESSAGE =
            "Unsupported Station Type";

    ChargingStationStatus(Long code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ChargingStationStatus forValue(String value) {
        ChargingStationStatus result = ChargingStationStatus.Holder.MAP.get(value);
        if (result == null) {
            throw new IllegalArgumentException(UNSUPPORTED_STATUS_MESSAGE + value);
        }
        return result;
    }

    public String toValue() {
        return this.description;
    }

    private static class Holder {
        static final Map<String, ChargingStationStatus> MAP = new HashMap<>();
    }
}
