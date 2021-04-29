package service.airport;

import model.airports.Airport;

import java.util.ArrayList;

public interface AirportService {
    Airport getAirport();

    ArrayList<Airport> getAirportList();

    int insertAirport(Airport airport);

    int deleteAirport(Airport airport);

    int updateAirport(Airport airport);
}
