package com.domain;

import model.airports.Airport;
import model.airports.Country;
import org.junit.jupiter.api.Test;
import repository.airport.AirportRepository;
import repository.airport.AirportRepositoryImpl;
import repository.airport.CountryRepository;
import repository.airport.CountryRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class AirportAppTest {
    @Test
    private void testAirport() {
        Airport airportDallas=new Airport("DFW","Dallas/Fort Worth International Airport",8);
        insertAirport(airportDallas);

        assertNotNull(getAirportList().stream().filter(airport ->
                airport.getCountryID()==(airportDallas.getCountryID()) &&
                        airport.getAirportCode().equals(airportDallas.getAirportCode()) &&
                        airport.getAirportName().equals(airportDallas.getAirportName())
        ).findAny().orElse(null));

        assertTrue(getAirportList().size()>0);
        assertNotNull(getAirport(new Airport(1)));

        updateAirport(new Airport(1,"SG_C","Changi Airport",1));
        assertEquals("SG_C",getAirport(new Airport(1)).getAirportCode());

        deleteAirport(new Airport(9));
        assertNull(getCountry(new Country(9)));
    }

    @Test
    private void testCountry() {
        Country countryDallas = new Country("United States", "Dallas", "TX");

        insertCountry(countryDallas);
        assertNotNull(getCountryList().stream().filter(country ->
                country.getCountryName().equals(countryDallas.getCountryName()) &&
                        country.getCountryCity().equals(countryDallas.getCountryCity()) &&
                        country.getCountryState().equals(countryDallas.getCountryState())
        ).findAny().orElse(null));

        assertTrue(getCountryList().size()>0);
        assertNotNull(getCountry(new Country(2)));
        updateCountry(new Country(1, "Singapore", "Singapore", "SG"));
        assertEquals("SG",getCountry(new Country(1)).getCountryState());

        deleteCountry(new Country(3));
        assertNull(getCountry(new Country(3)));
    }

    private static Airport getAirport(Airport airport) {
        AirportRepository airportRepository = new AirportRepositoryImpl();
        Airport result = airportRepository.getAirport(airport);
        return result;
    }

    private static ArrayList<Airport> getAirportList() {
        AirportRepository airportRepository = new AirportRepositoryImpl();
        ArrayList<Airport> airportArrayList = airportRepository.getAirportList();
       return airportArrayList;
    }

    private static void insertAirport(Airport airport) {
        AirportRepository airportRepository = new AirportRepositoryImpl();
        int rowInserted = airportRepository.insertAirport(airport);
        if (rowInserted > 0) {
            System.out.println("Airport inserted successful");
        } else {
            System.out.println("Airport inserted unsuccessful");

        }
    }
    private static void updateAirport(Airport airport) {
        AirportRepository airportRepository = new AirportRepositoryImpl();
        int rowInserted = airportRepository.updateAirport(airport);
        if (rowInserted > 0) {
            System.out.println("Airport updated successful");
        } else {
            System.out.println("Airport updated unsuccessful");

        }
    }

    private static void deleteAirport(Airport airport) {
        AirportRepository airportRepository = new AirportRepositoryImpl();
        int rowInserted = airportRepository.deleteAirport(airport);
        if (rowInserted > 0) {
            System.out.println("Airport deleted successful");
        } else {
            System.out.println("Airport deleted unsuccessful");

        }
    }

    private Country getCountry(Country country) {
        CountryRepository countryRepository = new CountryRepositoryImpl();
        Country result = countryRepository.getCountry(country);
        return result;

    }

    private ArrayList<Country> getCountryList() {
        CountryRepository countryRepository = new CountryRepositoryImpl();
        ArrayList<Country> countryArrayList = countryRepository.getCountryList();
        return countryArrayList;
    }

    private static void insertCountry(Country country) {
        CountryRepository countryRepository = new CountryRepositoryImpl();
        int rowInserted = countryRepository.insertCountry(country);
        if (rowInserted > 0) {
            System.out.println("Country inserted successful");
        } else {
            System.out.println("Country inserted unsuccessful");

        }
    }

    private static void updateCountry(Country country) {
        CountryRepository countryRepository = new CountryRepositoryImpl();
        int rowInserted = countryRepository.updateCountry(country);
        if (rowInserted > 0) {
            System.out.println("Country updated successful");
        } else {
            System.out.println("Country updated unsuccessful");

        }
    }

    private static void deleteCountry(Country country) {
        CountryRepository countryRepository = new CountryRepositoryImpl();
        int rowInserted = countryRepository.deleteCountry(country);
        if (rowInserted > 0) {
            System.out.println("Country deleted successful");
        } else {
            System.out.println("Country deleted unsuccessful");

        }
    }

}
