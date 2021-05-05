package com.domain.controller;

import com.domain.entity.Airport;
import com.domain.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//http://localhost:8080/ats/api
@RequestMapping("/api")
public class AirportController {
    @Autowired
    AirportRepository airportRepository;

    @GetMapping("/airports")
    public List<Airport> findAllProducts() {
        List<Airport> airports = airportRepository.findAll();
        return airports;
    }

    @GetMapping("/airports/{id}")
    public Airport findAirportById(@PathVariable(value = "id") Integer airportID) {
        Optional<Airport> optionalAirport = airportRepository.findById(airportID);
        Airport airport = optionalAirport.get();
        return airport;
    }

    @GetMapping("/airports/findByCode")
    public Airport findByAirportCode(@RequestParam(name = "code") String code) {
        Airport optionalAirport = airportRepository.findByCode(code);
        return optionalAirport;
    }

    @PostMapping("/airports")
    public Airport createAirport(@RequestBody Airport airport) {

        Airport airportReturned = airportRepository.save(airport);

        return airportReturned;
    }

    @PutMapping("/airports/{id}")
    public Airport updateAirport(@PathVariable(value = "id") Integer airportID, @RequestBody Airport airport) {
        Optional<Airport> optionalAirport = airportRepository.findById(airportID);
        Airport airportFromDB = optionalAirport.get();
        airportFromDB.setAirportCode(airport.getAirportCode());
        airportFromDB.setAirportName(airport.getAirportName());
        airportFromDB.setCountry(airport.getCountry());

        Airport airportReturned = airportRepository.save(airportFromDB);

        return airportReturned;
    }


    @DeleteMapping("/airports/{id}")
    public boolean deleteAirport(@PathVariable(value = "id") Integer airportID) {
        airportRepository.deleteById(airportID);
        return true;
    }
}
