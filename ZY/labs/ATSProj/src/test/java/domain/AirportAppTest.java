package domain;

import model.airports.Airport;
import model.airports.Country;
import org.junit.jupiter.api.*;
import repository.airport.AirportRepository;
import repository.airport.AirportRepositoryImpl;
import repository.airport.CountryRepository;
import repository.airport.CountryRepositoryImpl;
import service.airport.AirportService;
import service.airport.AirportServiceImpl;
import service.airport.CountryService;
import service.airport.CountryServiceImpl;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AirportAppTest {
    private static AirportService airportService = null;

    private static Airport airportDallas;
    @BeforeAll
    static void init() {
        airportDallas= new Airport("DFW_TEST", "Dallas/Fort Worth International Airport", 8);
        airportService = new AirportServiceImpl();
    }
    @Test
    @Order(1)
    void testAirport_insertAirport() {
        assertEquals(1, airportService.insertAirport(airportDallas));

        assertNotNull(airportService.getAirportList().stream().filter(airport ->
                airport.getCountryID() == (airportDallas.getCountryID()) &&
                        airport.getAirportCode().equals(airportDallas.getAirportCode()) &&
                        airport.getAirportName().equals(airportDallas.getAirportName())
        ).findAny().orElse(null));
    }
    @Test
    @Order(2)
    void testAirport_getAllAirports()
    {
        assertTrue(airportService.getAirportList().size() > 0);

    }
    @Test
    @Order(3)
    void testAirport_getAirportByID()
    {
        assertNotNull(airportService.getAirportByID(new Airport(1)));
    }
    @Test
    @Order(4)
    void testAirport_getAirportByCode()
    {
        assertNotNull(airportService.getAirportByCode(airportDallas));
    }
    @Test
    @Order(5)
    void testAirport_updateAirport()
    {
        assertEquals(1, airportService.updateAirport(new Airport(1, "SG_C", "Changi Airport", 1)));
        assertEquals("SG_C", airportService.getAirportByID(new Airport(1)).getAirportCode());
    }
    @Test
    @Order(6)
    void testAirport_deleteAirport()
    {

        airportService.deleteAirport(airportService.getAirportByCode(airportDallas));
        assertNull(airportService.getAirportByCode(airportDallas));
    }

//    @Test
//    void testCountry() {
//        Country countryDallas = new Country("United States", "Dallas", "TX");
//
//        insertCountry(countryDallas);
//        assertNotNull(getCountryList().stream().filter(country ->
//                country.getCountryName().equals(countryDallas.getCountryName()) &&
//                        country.getCountryCity().equals(countryDallas.getCountryCity()) &&
//                        country.getCountryState().equals(countryDallas.getCountryState())
//        ).findAny().orElse(null));
//
//        assertTrue(getCountryList().size() > 0);
//        assertNotNull(getCountry(new Country(2)));
//        updateCountry(new Country(1, "Singapore", "Singapore", "SG"));
//        assertEquals("SG", getCountry(new Country(1)).getCountryState());
//
//        deleteCountry(new Country(3));
//        assertNull(getCountry(new Country(3)));
//    }

//    private static Airport getAirport(Airport airport) {
//        AirportRepository airportService = new AirportRepositoryImpl();
//        Airport result = airportService.getAirportByID(airport);
//        return result;
//    }

//    private static ArrayList<Airport> getAirportList() {
//        AirportRepository airportService = new AirportRepositoryImpl();
//        ArrayList<Airport> airportArrayList = airportService.getAirportList();
//        return airportArrayList;
//    }

//    private static void insertAirport(Airport airport) {
//        AirportRepository airportService = new AirportRepositoryImpl();
//        int rowInserted = airportService.insertAirport(airport);
//        if (rowInserted > 0) {
//            System.out.println("Airport inserted successful");
//        } else {
//            System.out.println("Airport inserted unsuccessful");
//
//        }
//    }

//    private static void updateAirport(Airport airport) {
//        AirportRepository airportService = new AirportRepositoryImpl();
//        int rowInserted = airportService.updateAirport(airport);
//        if (rowInserted > 0) {
//            System.out.println("Airport updated successful");
//        } else {
//            System.out.println("Airport updated unsuccessful");
//
//        }
//    }
//
//    private static void deleteAirport(Airport airport) {
//        AirportRepository airportService = new AirportRepositoryImpl();
//        int rowInserted = airportService.deleteAirport(airport);
//        if (rowInserted > 0) {
//            System.out.println("Airport deleted successful");
//        } else {
//            System.out.println("Airport deleted unsuccessful");
//
//        }
//    }

//    private Country getCountry(Country country) {
//        CountryRepository countryRepository = new CountryRepositoryImpl();
//        Country result = countryRepository.getCountry(country);
//        return result;
//
//    }
//
//    private ArrayList<Country> getCountryList() {
//        CountryRepository countryRepository = new CountryRepositoryImpl();
//        ArrayList<Country> countryArrayList = countryRepository.getCountryList();
//        return countryArrayList;
//    }
//
//    private static void insertCountry(Country country) {
//        CountryRepository countryRepository = new CountryRepositoryImpl();
//        int rowInserted = countryRepository.insertCountry(country);
//        if (rowInserted > 0) {
//            System.out.println("Country inserted successful");
//        } else {
//            System.out.println("Country inserted unsuccessful");
//
//        }
//    }
//
//    private static void updateCountry(Country country) {
//        CountryRepository countryRepository = new CountryRepositoryImpl();
//        int rowInserted = countryRepository.updateCountry(country);
//        if (rowInserted > 0) {
//            System.out.println("Country updated successful");
//        } else {
//            System.out.println("Country updated unsuccessful");
//
//        }
//    }
//
//    private static void deleteCountry(Country country) {
//        CountryRepository countryRepository = new CountryRepositoryImpl();
//        int rowInserted = countryRepository.deleteCountry(country);
//        if (rowInserted > 0) {
//            System.out.println("Country deleted successful");
//        } else {
//            System.out.println("Country deleted unsuccessful");
//
//        }
//    }

}
