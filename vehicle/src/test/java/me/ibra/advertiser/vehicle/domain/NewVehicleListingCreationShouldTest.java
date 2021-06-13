package me.ibra.advertiser.vehicle.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NewVehicleListingCreationShouldTest {

    private Long    vehicleId;
    private String  vehicleType;
    private String  vehicleBrand;
    private String  vehicleModel;
    private Integer vehicleModelYear;
    private String  vehicleFuel;
    private String  vehicleGearBox;
    private String  vehicleColor;
    private Integer vehicleHorsePower;
    private Integer vehicleDoorCount;
    private Integer vehicleSeatCount;

    @BeforeEach
    void prepare_new_vehicle_data() {
        vehicleId = 1L;
        vehicleType = "CAR";
        vehicleBrand = "Renault";
        vehicleModel = "Captur";
        vehicleModelYear = 2016;
        vehicleFuel = "Gasoline";
        vehicleGearBox = "Manual";
        vehicleColor = "Black";
        vehicleHorsePower = 90;
        vehicleDoorCount = 5;
        vehicleSeatCount = 5;
    }

    @Test
    void create_new_vehicle_with_all_required_properties() {
        var constructedNewVehicle = new NewVehicleListing(
                vehicleId, vehicleType, vehicleBrand, vehicleModel, vehicleModelYear,
                vehicleFuel, vehicleGearBox, vehicleColor, vehicleHorsePower,
                vehicleDoorCount, vehicleSeatCount, null);

        assertEquals(vehicleId, constructedNewVehicle.id());
        assertEquals(vehicleType, constructedNewVehicle.type());
        assertEquals(vehicleBrand, constructedNewVehicle.brand());
        assertEquals(vehicleModel, constructedNewVehicle.model());
        assertEquals(vehicleModelYear, constructedNewVehicle.modelYear());
        assertEquals(vehicleFuel, constructedNewVehicle.fuel());
        assertEquals(vehicleGearBox, constructedNewVehicle.gearBox());
        assertEquals(vehicleColor, constructedNewVehicle.color());
        assertEquals(vehicleHorsePower, constructedNewVehicle.horsePower());
        assertEquals(vehicleDoorCount, constructedNewVehicle.doorCount());
        assertEquals(vehicleSeatCount, constructedNewVehicle.seatCount());
        assertNull(constructedNewVehicle.description());
    }

    @Test
    void fluently_build_new_vehicle_with_all_required_properties() {
        var builtNewVehicle = NewVehicleListing.builder()
                .id(vehicleId)
                .type(vehicleType)
                .brand(vehicleBrand)
                .model(vehicleModel)
                .modelYear(vehicleModelYear)
                .fuel(vehicleFuel)
                .gearBox(vehicleGearBox)
                .color(vehicleColor)
                .horsePower(vehicleHorsePower)
                .doorCount(vehicleDoorCount)
                .seatCount(vehicleSeatCount)
                .build();

        assertEquals(vehicleId, builtNewVehicle.id());
        assertEquals(vehicleType, builtNewVehicle.type());
        assertEquals(vehicleBrand, builtNewVehicle.brand());
        assertEquals(vehicleModel, builtNewVehicle.model());
        assertEquals(vehicleModelYear, builtNewVehicle.modelYear());
        assertEquals(vehicleFuel, builtNewVehicle.fuel());
        assertEquals(vehicleGearBox, builtNewVehicle.gearBox());
        assertEquals(vehicleColor, builtNewVehicle.color());
        assertEquals(vehicleHorsePower, builtNewVehicle.horsePower());
        assertEquals(vehicleDoorCount, builtNewVehicle.doorCount());
        assertEquals(vehicleSeatCount, builtNewVehicle.seatCount());
        assertNull(builtNewVehicle.description());
    }
}