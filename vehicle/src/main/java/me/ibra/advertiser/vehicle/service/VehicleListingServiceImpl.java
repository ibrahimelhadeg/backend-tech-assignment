package me.ibra.advertiser.vehicle.service;

import me.ibra.advertiser.vehicle.domain.VehicleListing;
import me.ibra.advertiser.vehicle.store.VehicleListingStore;

public class VehicleListingServiceImpl implements VehicleListingService {

    private final VehicleListingStore store;

    public VehicleListingServiceImpl(VehicleListingStore store) {
        this.store = store;
    }

    @Override
    public VehicleListing getVehicle(Long id) {
        return store.findById(id);
    }
}
