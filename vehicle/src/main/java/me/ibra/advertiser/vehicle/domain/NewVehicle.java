package me.ibra.advertiser.vehicle.domain;

import lombok.Builder;

public record NewVehicle(
        Long    id,
        String  type,
        String  brand,
        String  model,
        Integer modelYear,
        String  fuel,
        String  gearBox,
        String  color,
        Integer horsePower,
        Integer doorCount,
        Integer seatCount,
        String  description) implements Vehicle {

    @Builder
    public NewVehicle {}
}
