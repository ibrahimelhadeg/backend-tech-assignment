package me.ibra.advertiser.vehicle.store;

import me.ibra.advertiser.vehicle.domain.Vehicle;

public interface VehicleStore {

    Vehicle findById(Long id);
}
