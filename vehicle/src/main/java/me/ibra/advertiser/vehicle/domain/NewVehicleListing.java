package me.ibra.advertiser.vehicle.domain;

import lombok.Builder;

public record NewVehicleListing(
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
        String  description) implements VehicleListing {

    @Builder
    public NewVehicleListing {}
}
