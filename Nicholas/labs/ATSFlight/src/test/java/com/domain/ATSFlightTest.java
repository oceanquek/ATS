package com.domain;

import com.app.model.Flight;
import com.app.service.FlightService;
import com.app.service.FlightServiceImpl;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ATSFlightTest {
    @Test
    public void testCreateFlight() {
        Flight newFlight = new Flight(1,"Singapore","Hong Kong", "Changi International Airport", "Hong Kong International Airport", 200);
        assertEquals(1, newFlight.getFlightID());
        assertEquals("Singapore",newFlight.getDestAirport());
        assertEquals("Hong Kong",newFlight.getDepartCountry());
        assertEquals("Changi International Airport",newFlight.getDestAirport());
        assertEquals("Hong Kong International Airport",newFlight.getDepartAirport());
        assertNotEquals(300, newFlight.getCapacity());
    }

    @Test
    public void testInsertPlane() {
        Flight newFlight = new Flight(1,"Singapore","Hong Kong", "Changi International Airport", "Hong Kong International Airport", 200);
        FlightService flightService = new FlightServiceImpl();
        int result = flightService.insertFlightIntoDB(newFlight);
        assertNotEquals(result,0);
    }

    @Test
    public void getPlanes() {
        FlightService flightService = new FlightServiceImpl();
        ArrayList<Flight> flightsList = flightService.getFlights();
        assertEquals(flightsList.size(),2);
    }

    @Test
    public void updatePlane() {
        FlightService flightService = new FlightServiceImpl();
        Flight newFlight = new Flight(1,"Singapore","Hong Kong", "Changi International Airport", "Hong Kong International Airport", 200);
        int result = flightService.updateFlightInDB(newFlight.getFlightID(),newFlight);
        assertNotEquals(0,result);
    }

    @Test
    public void deletePlane() {
        FlightService flightService = new FlightServiceImpl();
        int result = flightService.removeFlightFromDB(2);
        assertNotEquals(0,result);
    }
}
