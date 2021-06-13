package me.ibra.advertiser.vehicle.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.ibra.advertiser.vehicle.domain.VehicleListing;
import me.ibra.advertiser.vehicle.service.VehicleListingService;

@RestController
@RequestMapping("vehicles")
public class VehicleListingRestController {

    private final VehicleListingService vehicleListingService;

    VehicleListingRestController(
            @Autowired VehicleListingService vehicleListingService) {
        this.vehicleListingService = vehicleListingService;
    }

    @GetMapping("/{id}")
    VehicleListing getVehicle(@PathVariable Long id) {
        VehicleListing vehicleListing = vehicleListingService.getVehicle(id);
        System.out.println("====================================================");
        System.out.println("====================================================");
        System.out.println(id);
        System.out.println(vehicleListingService.getClass().getName());
        System.out.println(vehicleListing);
        System.out.println("====================================================");
        System.out.println("====================================================");
        return vehicleListing;
    }
}
