package me.ibra.advertiser.vehicle.domain;

import java.time.YearMonth;

import lombok.Builder;

public record UsedVehicle(
        Long      id,
        String    type,
        String    brand,
        String    model,
        Integer   modelYear,
        YearMonth entryIntoService,
        String    fuel,
        String    gearBox,
        String    color,
        Integer   horsePower,
        Integer   doorCount,
        Integer   seatCount,
        String    condition,
        Long      mileage,
        String    description) implements Vehicle {

    @Builder
    public UsedVehicle {}
}
