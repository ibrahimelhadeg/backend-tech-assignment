package me.ibra.advertiser.vehicle.store;

import java.time.YearMonth;
import java.util.Map;

import me.ibra.advertiser.vehicle.domain.NewVehicle;
import me.ibra.advertiser.vehicle.domain.UsedVehicle;
import me.ibra.advertiser.vehicle.domain.Vehicle;

public class VehicleInMemoryStore implements VehicleStore {

    private final Map<Long, Vehicle> store = Map.of(
            1L,
            NewVehicle.builder()
                    .id(1L).type("CAR").brand("Renault").model("Captur")
                    .modelYear(2016).fuel("Gasoline").gearBox("Manual").color("Black")
                    .horsePower(90).doorCount(5).seatCount(5)
                    .build(),
            2L,
            UsedVehicle.builder()
                    .id(2L).type("CAR").brand("Renault").model("Captur").modelYear(2016)
                    .entryIntoService(YearMonth.of(2016, 10)).fuel("Gasoline")
                    .gearBox("Manual").color("Black").horsePower(90).doorCount(5)
                    .seatCount(5).condition("Very Good").mileage(30995L)
                    .build());

    @Override
    public Vehicle findById(Long id) {
        return store.get(id);
    }
}
