package domain;

import model.airports.Airport;
import model.airports.Country;
import org.junit.jupiter.api.*;
import service.airport.AirportServiceImpl;
import service.airport.CountryService;
import service.airport.CountryServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CountryAppTest {
    private static CountryService countryService = null;
    private static Country countryDallas;

    @BeforeAll
    static void init() {
        countryDallas = new Country("United_States_TEST", "Dallas", "TX");
        countryService = new CountryServiceImpl();
    }

    @Test
    @Order(1)
    void testAirport_insertAirport() {
        assertEquals(1, countryService.insertCountry(countryDallas));

        assertNotNull(countryService.getCountryList().stream().filter(country ->
                country.getCountryName().equals(countryDallas.getCountryName()) &&
                        country.getCountryCity().equals(countryDallas.getCountryCity()) &&
                        country.getCountryState().equals(countryDallas.getCountryState())
        ).findAny().orElse(null));
    }

    @Test
    @Order(2)
    void testAirport_getAllAirports() {
        assertTrue(airportService.getAirportList().size() > 0);

    }

    @Test
    @Order(3)
    void testAirport_getAirportByID() {
        assertNotNull(airportService.getAirportByID(new Airport(1)));
    }

    @Test
    @Order(4)
    void testAirport_getAirportByCode() {
        assertNotNull(airportService.getAirportByCode(airportDallas));
    }

    @Test
    @Order(5)
    void testAirport_updateAirport() {
        assertEquals(1, airportService.updateAirport(new Airport(1, "SG_C", "Changi Airport", 1)));
        assertEquals("SG_C", airportService.getAirportByID(new Airport(1)).getAirportCode());
    }

    @Test
    @Order(6)
    void testAirport_deleteAirport() {

        airportService.deleteAirport(airportService.getAirportByCode(airportDallas));
        assertNull(airportService.getAirportByCode(airportDallas));
    }

}
