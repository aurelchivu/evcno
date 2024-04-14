package com.optimiser.evcno.write.presentation.controller;

import com.optimiser.evcno.write.presentation.acl.adapter.ChargingStationCreationAdapter;
import com.optimiser.evcno.write.presentation.dto.request.ChargingStationCreationRequest;
import com.optimiser.evcno.write.presentation.dto.response.ChargingStationCreationResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/charging-station")
public class ChargingStationController {

    private final ChargingStationCreationAdapter chargingStationCreationAdapter;

    @PostMapping
    public Mono<ChargingStationCreationResponse> createChargingStation(
            @Valid @RequestBody ChargingStationCreationRequest chargingStationCreationRequest) {

        return chargingStationCreationAdapter.createChargingStation(chargingStationCreationRequest);
    }
}
