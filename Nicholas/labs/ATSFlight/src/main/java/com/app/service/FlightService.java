package com.app.service;

import com.app.model.Flight;

import java.util.ArrayList;

public interface FlightService {
    public Flight getFlight(int flightID);
    public ArrayList<Flight> getFlights();
    public int insertFlightIntoDB(Flight flight);
    public int removeFlightFromDB(int flightID);
    public int updateFlightInDB(int flightID, Flight flight);
}
