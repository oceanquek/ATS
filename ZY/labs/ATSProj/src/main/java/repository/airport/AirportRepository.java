package repository.airport;

import model.airports.Airport;

import java.util.ArrayList;

public interface AirportRepository {
    Airport getAirport();

    ArrayList<Airport> getAirportList();

    int insertAirport(Airport airport);

    int deleteAirport(Airport airport);

    int updateAirport(Airport airport);
}
