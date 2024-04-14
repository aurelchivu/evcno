package com.optimiser.evcno.write.presentation.acl.adapter;

import static com.optimiser.evcno.write.presentation.acl.validator.chargingstation.ChargingStationRequestCompositeValidator.CHARGING_STATION_CREATION_REQUEST;
import static reactor.core.publisher.Mono.fromCallable;
import static reactor.core.publisher.Mono.just;

import com.optimiser.evcno.write.application.service.chargingstation.ChargingStationCreationGatewayService;
import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import com.optimiser.evcno.write.presentation.acl.translator.ChargingStationResponseTranslator;
import com.optimiser.evcno.write.presentation.acl.translator.ChargingStationTranslator;
import com.optimiser.evcno.write.presentation.acl.validator.chargingstation.ChargingStationRequestCompositeValidator;
import com.optimiser.evcno.write.presentation.dto.request.ChargingStationCreationRequest;
import com.optimiser.evcno.write.presentation.dto.response.ChargingStationCreationResponse;
import lombok.RequiredArgsConstructor;
import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ChargingStationCreationAdapter {

    private final ChargingStationRequestCompositeValidator validator;
    private final ChargingStationTranslator chargingStationTranslator;
    private final ChargingStationCreationGatewayService chargingStationCreationGatewayService;
    private final ChargingStationResponseTranslator chargingStationResponseTranslator;

    public Mono<ChargingStationCreationResponse> createChargingStation(
            ChargingStationCreationRequest chargingStationCreationRequest) {

        return fromCallable(() -> validateRequest(chargingStationCreationRequest))
                .flatMap(this::translateRequestAndProcess)
                .flatMap(this::translateResponseFromService);
    }

    private ChargingStationCreationRequest validateRequest(
            ChargingStationCreationRequest chargingStationCreationRequest) throws Exception {

        Context context = buildValidationContext(chargingStationCreationRequest);
        validator.execute(context);

        return chargingStationCreationRequest;
    }

    private Context buildValidationContext(ChargingStationCreationRequest chargingStationCreationRequest) {

        final Context context = new ContextBase();
        context.put(CHARGING_STATION_CREATION_REQUEST, chargingStationCreationRequest);

        return context;
    }

    private Mono<ChargingStationId> translateRequestAndProcess(
            ChargingStationCreationRequest chargingStationCreationRequest) {

        ChargingStation chargingStation = chargingStationTranslator.toChargingStation(chargingStationCreationRequest);

        return chargingStationCreationGatewayService.createChargingStation(chargingStation);
    }

    private Mono<ChargingStationCreationResponse> translateResponseFromService(ChargingStationId chargingStationId) {

        return chargingStationResponseTranslator.toChargingStationCreationResponse(just(chargingStationId));
    }
}
