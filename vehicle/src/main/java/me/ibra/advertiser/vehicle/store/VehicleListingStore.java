package me.ibra.advertiser.vehicle.store;

import me.ibra.advertiser.vehicle.domain.VehicleListing;

public interface VehicleListingStore {

    VehicleListing findById(Long id);
}
