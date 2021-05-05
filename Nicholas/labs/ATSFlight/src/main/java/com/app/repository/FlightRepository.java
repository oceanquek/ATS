package com.app.repository;

import com.app.model.Flight;

import java.util.ArrayList;

public interface FlightRepository {
    public ArrayList<Flight> getFlights();
    int insertFlight(Flight flight);
    public int UpdateFlight(int flightID, Flight flight);
    public int DeleteFlightPreparedStatement(int flightID);
    public Flight getFlight(int flightID);
}
