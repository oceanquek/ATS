package repository.airport;

import model.airports.Airport;

import java.util.ArrayList;

public interface AirportRepository {
    Airport getAirportByID(Airport airport);
    Airport getAirportByCode(Airport airport);
    ArrayList<Airport> getAirportList();

    int insertAirport(Airport airport);

    int deleteAirport(Airport airport);

    int updateAirport(Airport airport);
}
