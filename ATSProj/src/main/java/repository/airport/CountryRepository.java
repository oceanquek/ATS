package repository.airport;


import model.airports.Country;

import java.util.ArrayList;

public interface CountryRepository {
    Country getCountryByID(Country country);

    Country getCountryByName(Country country);

    ArrayList<Country> getCountryList();

    int insertCountry(Country country);

    int deleteCountry(Country country);

    int updateCountry(Country country);
}
