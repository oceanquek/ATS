package com.domain.controller;

import com.domain.entity.Flight;
import com.domain.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;

    @GetMapping("/flights")
    public List<Flight> findAllFlights(){
        List<Flight> flightArrayList = flightRepository.findAll();
        return flightArrayList;
    }

    @GetMapping("/flights/{flightID}")
    public Flight findFlightByID(@PathVariable(value = "id") long flightId) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        Flight flight = optionalFlight.get();
        return flight;
    }

    @PostMapping("/flights")
    public Flight createFlight(@RequestBody Flight flight){
        Flight returnedFlight = flightRepository.save(flight);
        return returnedFlight;
    }

    @PutMapping("/flights/{id}")
    public Flight updateFlight(@PathVariable(value = "id") Long flightId, @RequestBody Flight flight){
        Optional<Flight> optionalFlight = flightRepository.findById(flightId);
        Flight flightFromDB = optionalFlight.get();
        flightFromDB.setDestCountry(flight.getDestCountry());
        flightFromDB.setDepartCountry(flight.getDepartCountry());
        flightFromDB.setDestAirport(flight.getDestAirport());
        flightFromDB.setDepartAirport(flight.getDepartAirport());
        flightFromDB.setCapacity(flight.getCapacity());
        Flight returnedFlight = flightRepository.save(flightFromDB);
        return returnedFlight;
    }

    @DeleteMapping("flights/{id}")
    public boolean deleteFlight(@PathVariable(value = "id") Long flightId){
        flightRepository.deleteById(flightId);
        return true;
    }
}
