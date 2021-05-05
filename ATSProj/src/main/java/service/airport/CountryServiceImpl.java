package service.airport;

import model.airports.Country;
import repository.airport.CountryRepository;
import repository.airport.CountryRepositoryImpl;

import java.util.ArrayList;

public class CountryServiceImpl implements CountryService{
    CountryRepository countryRepository=null;

    public CountryServiceImpl() {
        countryRepository=new CountryRepositoryImpl();
    }

    @Override
    public Country getCountryByID(Country country) {
        return countryRepository.getCountryByID(country);
    }

    @Override
    public Country getCountryByName(Country country) {
        return countryRepository.getCountryByName(country);
    }

    @Override
    public ArrayList<Country> getCountryList() {
        return countryRepository.getCountryList();
    }

    @Override
    public int insertCountry(Country country) {
        return countryRepository.insertCountry(country);
    }

    @Override
    public int deleteCountry(Country country) {
        return countryRepository.deleteCountry(country);
    }

    @Override
    public int updateCountry(Country country) {
        return countryRepository.updateCountry(country);
    }
}
