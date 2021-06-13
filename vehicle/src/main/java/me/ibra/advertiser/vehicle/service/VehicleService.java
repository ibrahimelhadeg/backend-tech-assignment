package me.ibra.advertiser.vehicle.service;

import me.ibra.advertiser.vehicle.domain.Vehicle;
import me.ibra.advertiser.vehicle.store.VehicleStore;

public class VehicleService {

    private final VehicleStore store;

    public VehicleService(VehicleStore store) {
        this.store = store;
    }

    public Vehicle getVehicle(Long id) {
        return store.findById(id);
    }
}
