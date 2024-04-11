package com.optimiser.evcno.write.domain.valueobject;

import java.util.HashMap;
import java.util.Map;

public enum StationType {

    STANDARD(0L, "Standard"),
    FAST_CHARGING(1L, "FastCharging");

    private final Long code;
    private final String description;
    private static final String UNSUPPORTED_STATION_TYPE_MESSAGE =
            "Unsupported Station Type";

    StationType(Long code, String description) {
        this.code = code;
        this.description = description;
    }

    public static StationType forValue(String value) {
        StationType result = Holder.MAP.get(value);
        if (result == null) {
            throw new IllegalArgumentException(UNSUPPORTED_STATION_TYPE_MESSAGE + value);
        }
        return result;
    }

    public String toValue() {
        return this.description;
    }

    private static class Holder {
        static final Map<String, StationType> MAP = new HashMap<>();
    }
}
