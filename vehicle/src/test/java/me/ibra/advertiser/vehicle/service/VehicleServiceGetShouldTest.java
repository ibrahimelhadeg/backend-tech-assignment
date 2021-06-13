package me.ibra.advertiser.vehicle.service;

import java.time.YearMonth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.ibra.advertiser.vehicle.domain.NewVehicle;
import me.ibra.advertiser.vehicle.domain.UsedVehicle;
import me.ibra.advertiser.vehicle.store.VehicleStore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VehicleServiceGetShouldTest {
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

    private VehicleService vehicleService;

    @BeforeEach
    void prepare_vehicles() {
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

        VehicleStore vehicleStore = mock(VehicleStore.class);
        when(vehicleStore.findById(newVehicleId)).thenReturn(
                NewVehicle.builder()
                        .id(newVehicleId).type(vehicleType).brand(vehicleBrand)
                        .model(vehicleModel).modelYear(vehicleModelYear).fuel(vehicleFuel)
                        .gearBox(vehicleGearBox).color(vehicleColor).horsePower(vehicleHorsePower)
                        .doorCount(vehicleDoorCount).seatCount(vehicleSeatCount)
                        .build());
        when(vehicleStore.findById(usedVehicleId)).thenReturn(
                UsedVehicle.builder()
                        .id(usedVehicleId).type(vehicleType).brand(vehicleBrand)
                        .model(vehicleModel).modelYear(vehicleModelYear)
                        .entryIntoService(vehicleEntryIntoService).fuel(vehicleFuel)
                        .gearBox(vehicleGearBox).color(vehicleColor).horsePower(vehicleHorsePower)
                        .doorCount(vehicleDoorCount).seatCount(vehicleSeatCount)
                        .condition(vehicleCondition).mileage(vehicleMileage)
                        .build());
        vehicleService = new VehicleService(vehicleStore);
    }

    @Test
    void should_get_new_vehicle_by_id() {
        var vehicleOfIdOne = (NewVehicle) vehicleService.getVehicle(newVehicleId);

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
        var vehicleOfIdOne = (UsedVehicle) vehicleService.getVehicle(usedVehicleId);

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
