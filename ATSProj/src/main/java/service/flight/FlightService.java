package service.flight;

import model.flights.Flight;
import java.util.ArrayList;

public interface FlightService {

    public ArrayList<Flight> getFlights();
    public int insertFlight(Flight flight);
    public int removeFlight(Flight flight);
    public int updateFlight(Flight flight);

}
