package me.ibra.advertiser.vehicle.service;

import java.time.YearMonth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import me.ibra.advertiser.vehicle.domain.NewVehicleListing;
import me.ibra.advertiser.vehicle.domain.UsedVehicleListing;
import me.ibra.advertiser.vehicle.store.VehicleListingStore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VehicleListingServiceImplGetShouldTest {
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

    private VehicleListingServiceImpl vehicleListingServiceImpl;

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

        VehicleListingStore vehicleListingStore = mock(VehicleListingStore.class);
        when(vehicleListingStore.findById(newVehicleId)).thenReturn(
                NewVehicleListing.builder()
                        .id(newVehicleId).type(vehicleType).brand(vehicleBrand)
                        .model(vehicleModel).modelYear(vehicleModelYear).fuel(vehicleFuel)
                        .gearBox(vehicleGearBox).color(vehicleColor).horsePower(vehicleHorsePower)
                        .doorCount(vehicleDoorCount).seatCount(vehicleSeatCount)
                        .build());
        when(vehicleListingStore.findById(usedVehicleId)).thenReturn(
                UsedVehicleListing.builder()
                        .id(usedVehicleId).type(vehicleType).brand(vehicleBrand)
                        .model(vehicleModel).modelYear(vehicleModelYear)
                        .entryIntoService(vehicleEntryIntoService).fuel(vehicleFuel)
                        .gearBox(vehicleGearBox).color(vehicleColor).horsePower(vehicleHorsePower)
                        .doorCount(vehicleDoorCount).seatCount(vehicleSeatCount)
                        .condition(vehicleCondition).mileage(vehicleMileage)
                        .build());
        vehicleListingServiceImpl = new VehicleListingServiceImpl(vehicleListingStore);
    }

    @Test
    void should_get_new_vehicle_by_id() {
        var vehicleOfIdOne = (NewVehicleListing) vehicleListingServiceImpl.getVehicle(newVehicleId);

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
        var vehicleOfIdOne = (UsedVehicleListing) vehicleListingServiceImpl.getVehicle(usedVehicleId);

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
