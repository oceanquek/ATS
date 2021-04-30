package service.airport;


import model.airports.Airport;
import repository.airport.AirportRepository;
import repository.airport.AirportRepositoryImpl;

import java.util.ArrayList;

public class AirportServiceImpl implements AirportService {
    AirportRepository airportRepository=null;

    public AirportServiceImpl() {
        airportRepository=new AirportRepositoryImpl();
    }

    @Override
    public Airport getAirport(Airport airport) {
        return airportRepository.getAirport(airport);
    }

    @Override
    public ArrayList<Airport> getAirportList() {
        return airportRepository.getAirportList();
    }

    @Override
    public int insertAirport(Airport airport) {
        return airportRepository.insertAirport(airport);
    }

    @Override
    public int deleteAirport(Airport airport) {
        return airportRepository.deleteAirport(airport);
    }

    @Override
    public int updateAirport(Airport airport) {
        return airportRepository.updateAirport(airport);
    }
}
