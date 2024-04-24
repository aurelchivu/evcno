package com.optimiser.evcno.write.infrastructure.kafka.translator.chargingstationdata;

import com.optimiser.evcno.published.language.infrastructure.avro.v1.ChargingStationDataAvro;

import com.optimiser.evcno.write.domain.model.ChargingStation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ChargingStationDataTranslator {

    ChargingStationDataTranslator INSTANCE = Mappers.getMapper(ChargingStationDataTranslator.class);

    @Mapping(target = "chargingStationId",expression = "java(chargingStation.getChargingStationId().getPrimaryId())")
    @Mapping(target = "name", source = "name")
//    @Mapping(target = "address", source = "address")
    @Mapping(target = "capacity", source = "capacity")
    @Mapping(target = "availableChargingPoints", source = "availableChargingPoints")
//    @Mapping(target = "chargingStationType", source = "chargingStationType")
//    @Mapping(target = "chargingStationStatus", source = "chargingStationStatus")
    ChargingStationDataAvro mapToChargingStationDataAvro(ChargingStation chargingStation);
}
