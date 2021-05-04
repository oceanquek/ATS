package repository.flight;

import model.flights.Flight;

import java.util.ArrayList;

public interface FlightRepository {
    public ArrayList<Flight> getFlights();
    public int insertFlightPreparedStatement(Flight flight);
    public int UpdateFlightPreparedStatement(Flight flight);
    public int DeleteFlightPreparedStatement(Flight flight);
    public Flight getFlight(Flight flight);
}
