package com.domain.controller;

import com.domain.entity.Country;
import com.domain.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//http://localhost:8080/ats/api
@RequestMapping("/api")
public class CountryController {
    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/countries")
    public List<Country> findAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countries;
    }

    @GetMapping("/countries/{id}")
    public Country findCountryById(@PathVariable(value = "id") Integer countryID) {
        Optional<Country> optionalCountry = countryRepository.findById(countryID);
        Country country = optionalCountry.get();
        return country;
    }

    //    @GetMapping("/airports")
//    public Airport findByairportCode(@RequestParam(name = "code") String code) {
//        Airport optionalAirport = airportRepository.(code);
//        return optionalAirport;
//    }
    @PostMapping("/countries")
    public Country createCountry(@RequestBody Country country) {

        Country countryReturned = countryRepository.save(country);

        return countryReturned;
    }

    @PutMapping("/countries/{id}")
    public Country updateCountry(@PathVariable(value = "id") Integer countryID, @RequestBody Country country) {
        Optional<Country> optionalCountry = countryRepository.findById(countryID);
        Country countryFromDB = optionalCountry.get();
        countryFromDB.setCountryName(country.getCountryName());
        countryFromDB.setCountryCity(country.getCountryCity());
        countryFromDB.setCountryState(country.getCountryState());
        Country countryReturned = countryRepository.save(countryFromDB);

        return countryReturned;
    }


    @DeleteMapping("/countries/{id}")
    public boolean deleteCountry(@PathVariable(value = "id") Integer countryID) {
        countryRepository.deleteById(countryID);
        return true;
    }
}
