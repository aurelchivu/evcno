package com.optimiser.evcno.write.application.command.chargingstation;

import com.optimiser.evcno.write.application.command.Command;
import com.optimiser.evcno.write.domain.model.ChargingStation;
import com.optimiser.evcno.write.domain.valueobject.ChargingStationId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class CreateChargingStationCommand implements Serializable, Command {

    @TargetAggregateIdentifier private final ChargingStationId chargingStationId;
    private final ChargingStation chargingStation;
}
