package domain;

import model.airports.Country;
import model.airports.Country;
import org.junit.jupiter.api.*;
import service.airport.CountryServiceImpl;
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
    void testCountry_insertCountry() {
        assertEquals(1, countryService.insertCountry(countryDallas));

        assertNotNull(countryService.getCountryList().stream().filter(country ->
                country.getCountryName().equals(countryDallas.getCountryName()) &&
                        country.getCountryCity().equals(countryDallas.getCountryCity()) &&
                        country.getCountryState().equals(countryDallas.getCountryState())
        ).findAny().orElse(null));
    }

    @Test
    @Order(2)
    void testCountry_getAllCountrys() {
        assertTrue(countryService.getCountryList().size() > 0);

    }

    @Test
    @Order(3)
    void testCountry_getCountryByID() {
        assertNotNull(countryService.getCountryByID(new Country(1)));
    }

    @Test
    @Order(4)
    void testCountry_getCountryByCode() {
        assertNotNull(countryService.getCountryByName(countryDallas));
    }

    @Test
    @Order(5)
    void testCountry_updateCountry() {
        assertEquals(1, countryService.updateCountry(new Country(1, "Singapore", "Singapore", "SG")));
        assertEquals("Singapore", countryService.getCountryByID(new Country(1)).getCountryName());
    }

    @Test
    @Order(6)
    void testCountry_deleteCountry() {

        countryService.deleteCountry(countryService.getCountryByName(countryDallas));
        assertNull(countryService.getCountryByName(countryDallas));
    }

}
