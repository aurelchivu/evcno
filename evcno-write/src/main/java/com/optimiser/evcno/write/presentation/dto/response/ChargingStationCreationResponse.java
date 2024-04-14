package com.optimiser.evcno.write.presentation.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
@Schema(description = "Charging Station Server Response")
public class ChargingStationCreationResponse {

    @Schema(description = "The charging station id that has been created")
    String chargingStationId;
}
