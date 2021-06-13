package me.ibra.advertiser.vehicle.endpoint;

import java.time.YearMonth;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;

import io.restassured.RestAssured;
import me.ibra.advertiser.vehicle.domain.UsedVehicleListing;
import me.ibra.advertiser.vehicle.service.VehicleListingService;

import static org.hamcrest.Matchers.equalTo;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {
        VehicleListingEndpoint.class,
        VehicleListingRestController.class })
public class VehicleListingEndpointTest {

    @LocalServerPort
    private int port;

    @MockBean
    private VehicleListingService vehicleListingService;

    @BeforeEach
    public void set_up_random_port() {
        RestAssured.port = port;
    }

    @Test
    void context_loads_successfully() { }

    @Test
    void vehicle_resource_returns_200_with_expected_id_and_vehicles() {

        Mockito.when(vehicleListingService.getVehicle(2L)).thenReturn(
                UsedVehicleListing.builder()
                        .id(2L).type("CAR").brand("Renault").model("Captur").modelYear(2016)
                        .entryIntoService(YearMonth.of(2016, 10)).fuel("Gasoline")
                        .gearBox("Manual").color("Black").horsePower(90).doorCount(5)
                        .seatCount(5).condition("Very Good").mileage(30995L)
                        .build());

        RestAssured
            .when()
                .get("/vehicles/{id}", 2)
            .then()
                .statusCode(200)
                .body("id", equalTo(2),
                        "type", equalTo("CAR"),
                        "type", equalTo("CAR"),
                        "brand", equalTo("Renault"),
                        "model", equalTo("Captur"),
                        "modelYear", equalTo(2016),
                        "entryIntoService", equalTo("2016-10"),
                        "fuel", equalTo("Gasoline"),
                        "color", equalTo("Black"),
                        "horsePower", equalTo(90),
                        "doorCount", equalTo(5),
                        "seatCount", equalTo(5),
                        "condition", equalTo("Very Good"),
                        "mileage", equalTo(30995));
    }
}
