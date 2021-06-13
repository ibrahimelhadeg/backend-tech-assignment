package me.ibra.advertiser.vehicle.store;

import java.time.YearMonth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.ibra.advertiser.vehicle.domain.NewVehicle;
import me.ibra.advertiser.vehicle.domain.UsedVehicle;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class VehicleInMemoryStoreShouldTest {

    private Long      newVehicleId;
    private Long      usedVehicleId;
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

    private VehicleInMemoryStore vehicleStore;

    @BeforeEach
    void prepare_ForUsedVehicle() {
        newVehicleId = 1L;
        usedVehicleId = 2L;
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
        vehicleStore = new VehicleInMemoryStore();
    }

    @Test
    void should_get_new_vehicle_by_id() {
        var vehicleOfIdOne = (NewVehicle) vehicleStore.findById(newVehicleId);

        assertEquals(newVehicleId, vehicleOfIdOne.id());
        assertEquals(vehicleType, vehicleOfIdOne.type());
        assertEquals(vehicleBrand, vehicleOfIdOne.brand());
        assertEquals(vehicleModel, vehicleOfIdOne.model());
        assertEquals(vehicleModelYear, vehicleOfIdOne.modelYear());
        assertEquals(vehicleFuel, vehicleOfIdOne.fuel());
        assertEquals(vehicleGearBox, vehicleOfIdOne.gearBox());
        assertEquals(vehicleColor, vehicleOfIdOne.color());
        assertEquals(vehicleHorsePower, vehicleOfIdOne.horsePower());
        assertEquals(vehicleDoorCount, vehicleOfIdOne.doorCount());
        assertEquals(vehicleSeatCount, vehicleOfIdOne.seatCount());
        assertNull(vehicleOfIdOne.description());
    }

    @Test
    void should_get_used_vehicle_by_id() {
        var vehicleOfIdOne = (UsedVehicle) vehicleStore.findById(usedVehicleId);

        assertEquals(usedVehicleId, vehicleOfIdOne.id());
        assertEquals(vehicleType, vehicleOfIdOne.type());
        assertEquals(vehicleBrand, vehicleOfIdOne.brand());
        assertEquals(vehicleModel, vehicleOfIdOne.model());
        assertEquals(vehicleModelYear, vehicleOfIdOne.modelYear());
        assertEquals(vehicleEntryIntoService, vehicleOfIdOne.entryIntoService());
        assertEquals(vehicleFuel, vehicleOfIdOne.fuel());
        assertEquals(vehicleGearBox, vehicleOfIdOne.gearBox());
        assertEquals(vehicleColor, vehicleOfIdOne.color());
        assertEquals(vehicleHorsePower, vehicleOfIdOne.horsePower());
        assertEquals(vehicleDoorCount, vehicleOfIdOne.doorCount());
        assertEquals(vehicleSeatCount, vehicleOfIdOne.seatCount());
        assertEquals(vehicleCondition, vehicleOfIdOne.condition());
        assertEquals(vehicleMileage, vehicleOfIdOne.mileage());
        assertNull(vehicleOfIdOne.description());
    }
}
