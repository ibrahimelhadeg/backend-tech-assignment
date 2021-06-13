package me.ibra.advertiser.vehicle.domain;

import java.time.YearMonth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class UsedVehicleCreationShouldTest {

    private Long      vehicleId;
    private String    vehicleType;
    private String    vehicleBrand;
    private String    vehicleModel;
    private Integer   vehicleModelYear;
    private YearMonth vehicleEntryIntoService;
    private String    vehicleFuel;
    private String    vehicleGearBox;
    private String    vehicleColor;
    private Integer   vehicleHorsePower;
    private Integer   vehicleDoorCount;
    private Integer   vehicleSeatCount;
    private String    vehicleCondition;
    private Long      vehicleMileage;

    @BeforeEach
    void prepare_used_vehicle_data() {
        vehicleId = 1L;
        vehicleType = "CAR";
        vehicleBrand = "Renault";
        vehicleModel = "Captur";
        vehicleModelYear = 2016;
        vehicleEntryIntoService = YearMonth.of(2016, 10);
        vehicleFuel = "Gasoline";
        vehicleGearBox = "Manual";
        vehicleColor = "Black";
        vehicleHorsePower = 90;
        vehicleDoorCount = 5;
        vehicleSeatCount = 5;
        vehicleCondition = "Very Good";
        vehicleMileage = 30995L;
    }

    @Test
    void create_used_vehicle_with_all_required_properties() {
        var constructedUsedVehicle = new UsedVehicle(
                vehicleId, vehicleType, vehicleBrand, vehicleModel, vehicleModelYear,
                vehicleEntryIntoService, vehicleFuel, vehicleGearBox, vehicleColor,
                vehicleHorsePower, vehicleDoorCount, vehicleSeatCount, vehicleCondition,
                vehicleMileage, null);

        assertEquals(vehicleId, constructedUsedVehicle.id());
        assertEquals(vehicleType, constructedUsedVehicle.type());
        assertEquals(vehicleBrand, constructedUsedVehicle.brand());
        assertEquals(vehicleModel, constructedUsedVehicle.model());
        assertEquals(vehicleModelYear, constructedUsedVehicle.modelYear());
        assertEquals(vehicleEntryIntoService, constructedUsedVehicle.entryIntoService());
        assertEquals(vehicleFuel, constructedUsedVehicle.fuel());
        assertEquals(vehicleGearBox, constructedUsedVehicle.gearBox());
        assertEquals(vehicleColor, constructedUsedVehicle.color());
        assertEquals(vehicleHorsePower, constructedUsedVehicle.horsePower());
        assertEquals(vehicleDoorCount, constructedUsedVehicle.doorCount());
        assertEquals(vehicleSeatCount, constructedUsedVehicle.seatCount());
        assertEquals(vehicleCondition, constructedUsedVehicle.condition());
        assertEquals(vehicleMileage, constructedUsedVehicle.mileage());
        assertNull(constructedUsedVehicle.description());
    }

    @Test
    void fluently_build_used_vehicle_with_all_required_properties() {
        var builtUsedVehicle = UsedVehicle.builder()
                .id(vehicleId)
                .type(vehicleType)
                .brand(vehicleBrand)
                .model(vehicleModel)
                .modelYear(vehicleModelYear)
                .entryIntoService(vehicleEntryIntoService)
                .fuel(vehicleFuel)
                .gearBox(vehicleGearBox)
                .color(vehicleColor)
                .horsePower(vehicleHorsePower)
                .doorCount(vehicleDoorCount)
                .seatCount(vehicleSeatCount)
                .condition(vehicleCondition)
                .mileage(vehicleMileage)
                .build();

        assertEquals(vehicleId, builtUsedVehicle.id());
        assertEquals(vehicleType, builtUsedVehicle.type());
        assertEquals(vehicleBrand, builtUsedVehicle.brand());
        assertEquals(vehicleModel, builtUsedVehicle.model());
        assertEquals(vehicleModelYear, builtUsedVehicle.modelYear());
        assertEquals(vehicleEntryIntoService, builtUsedVehicle.entryIntoService());
        assertEquals(vehicleFuel, builtUsedVehicle.fuel());
        assertEquals(vehicleGearBox, builtUsedVehicle.gearBox());
        assertEquals(vehicleColor, builtUsedVehicle.color());
        assertEquals(vehicleHorsePower, builtUsedVehicle.horsePower());
        assertEquals(vehicleDoorCount, builtUsedVehicle.doorCount());
        assertEquals(vehicleSeatCount, builtUsedVehicle.seatCount());
        assertEquals(vehicleCondition, builtUsedVehicle.condition());
        assertEquals(vehicleMileage, builtUsedVehicle.mileage());
        assertNull(builtUsedVehicle.description());
    }
}
