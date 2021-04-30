package service.airport;

import model.airports.Country;

import java.util.ArrayList;

public interface CountryService {
    Country getCountry();

    ArrayList<Country> getCountryList();

    int insertCountry(Country country);

    int deleteCountry(Country country);

    int updateCountry(Country country);
}