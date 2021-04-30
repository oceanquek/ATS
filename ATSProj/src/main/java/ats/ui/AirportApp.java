package ats.ui;

import model.airports.Airport;
import model.airports.Country;
import repository.airport.AirportRepository;
import repository.airport.AirportRepositoryImpl;
import repository.airport.CountryRepository;
import repository.airport.CountryRepositoryImpl;

import java.util.ArrayList;

public class AirportApp {
    public static void main(String[] args) {
        System.out.println("Welcome to ATS!");

        Country countryDallas=new Country("United States","Dallas","TX");
        Country countryAtlanta=new Country("United States","Atlanta","ATL");

        insertCountry(countryAtlanta);
        insertCountry(countryDallas);
        getCountryList();
        getCountry(new Country(2));
        updateCountry(new Country(1,"Singapore","Singapore","SG"));
        deleteCountry(new Country(3));


        Airport airportSG=new Airport("SGC","Changi",1);
        Airport airportChicago=new Airport("ORD","O'Hare International Airport",5);
        Airport airportDallas=new Airport("DFW","Dallas/Fort Worth International Airport",8);

        insertAirport(airportSG);
        insertAirport(airportChicago);
        insertAirport(airportDallas);
        getAirportList();
        getAirport(new Airport(1));
        updateAirport(new Airport(1,"SG_C","Changi Airport",1));
        deleteAirport(new Airport(3));
    }

    private static void getAirport(Airport airport) {
        AirportRepository airportRepository = new AirportRepositoryImpl();
        Airport result = airportRepository.getAirport(airport);
        System.out.println(result);

    }

    private static void getAirportList() {
        AirportRepository airportRepository = new AirportRepositoryImpl();
        ArrayList<Airport> airportArrayList = airportRepository.getAirportList();
        System.out.println(airportArrayList);
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



    private static void getCountry(Country country) {
        CountryRepository countryRepository = new CountryRepositoryImpl();
        Country result = countryRepository.getCountry(country);
        System.out.println(result);

    }

    private static void getCountryList() {
        CountryRepository countryRepository = new CountryRepositoryImpl();
        ArrayList<Country> countryArrayList = countryRepository.getCountryList();
        System.out.println(countryArrayList);
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
