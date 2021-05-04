package service.flight;

import model.flights.Flight;
import repository.flight.FlightRepository;
import repository.flight.FlightRepositoryImpl;

import java.util.ArrayList;

public class FlightServiceImpl implements FlightService{

    FlightRepository flightRepository = null;

    public FlightServiceImpl(){
        System.out.println("FlightService instantiated");
        flightRepository = new FlightRepositoryImpl();

    }

    @Override
    public ArrayList<Flight> getFlights() {
        return flightRepository.getFlights();
    }

    @Override
    public int insertFlight(Flight flight) {
        int flightInserted = flightRepository.insertFlightPreparedStatement(flight);
        return flightInserted;
    }

    @Override
    public int removeFlight(Flight flight) {
        int flightRemoved = flightRepository.DeleteFlightPreparedStatement(flight);
        return flightRemoved;
    }

    @Override
    public int updateFlight(Flight flight) {
        int flightUpdated = flightRepository.UpdateFlightPreparedStatement(flight);
        return flightUpdated;
    }
}
