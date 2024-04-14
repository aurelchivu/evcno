package com.optimiser.evcno.write.presentation.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Value;

@Schema(description = "Information needed to create a new charging station")
@Builder
@Value
public class ChargingStationCreationRequest {

    @Schema(description = "The name of the charging Station")
    @NotBlank(message = "The name cannot be blank")
    String name;

    @Schema(description = "The address of the charging Station")
    String address;

    @Schema(description = "The number of charging points")
    int capacity;

    @Schema(description = "(Available charging points")
    int availableChargingPoints;

    @Schema(description = "The type of the station: fast charging, standard")
    String chargingStationType;

    @Schema(description = "The status of the station: fast operational, maintenance")
    String chargingStationStatus;

    @JsonCreator
    public ChargingStationCreationRequest(
            @JsonProperty("name") String name,
            @JsonProperty("address") String address,
            @JsonProperty("capacity") int capacity,
            @JsonProperty("availableChargingPoints") int availableChargingPoints,
            @JsonProperty("chargingStationType") String chargingStationType,
            @JsonProperty("chargingStationStatus") String chargingStationStatus
    ) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.availableChargingPoints = availableChargingPoints;
        this.chargingStationType = chargingStationType;
        this.chargingStationStatus = chargingStationStatus;
    }
}
