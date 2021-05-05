package com.app.service;

import com.app.model.Flight;
import com.app.repository.FlightRepository;
import com.app.repository.FlightRepositoryImpl;

import java.util.ArrayList;

public class FlightServiceImpl implements FlightService{

    FlightRepository flightRepository = null;

    public FlightServiceImpl(){
        System.out.println("FlightService instantiated");
        flightRepository = new FlightRepositoryImpl();

    }

    @Override
    public Flight getFlight(int flightID) {
        return flightRepository.getFlight(flightID);
    }

    @Override
    public ArrayList<Flight> getFlights() {
        return flightRepository.getFlights();
    }

    @Override
    public int insertFlightIntoDB(Flight flight) {
        int flightInserted = flightRepository.insertFlight(flight);
        return flightInserted;
    }

    @Override
    public int removeFlightFromDB(int flightID) {
        int flightRemoved = flightRepository.DeleteFlightPreparedStatement(flightID);
        return flightRemoved;
    }

    @Override
    public int updateFlightInDB(int flightID, Flight flight) {
        int flightUpdated = flightRepository.UpdateFlight(flightID, flight);
        return flightUpdated;
    }

}
