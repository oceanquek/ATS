package com.app.repository;

import com.app.model.Flight;
import com.app.repository.util.MySQLConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class FlightRepositoryImpl implements FlightRepository{

    public FlightRepositoryImpl(){
        System.out.println("FlightRepository instantiated.");
    }

    @Override
    public ArrayList<Flight> getFlights() {
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM FLIGHTS");
            while(resultSet.next()){
                Flight flight = new Flight();
                flight.setFlightID(resultSet.getInt(1));
                flight.setDestCountry(resultSet.getString(2));
                flight.setDepartCountry(resultSet.getString(3));
                flight.setDestAirport(resultSet.getString(4));
                flight.setDepartAirport(resultSet.getString(5));
                flight.setCapacity(resultSet.getInt(6));
                flights.add(flight);
            }

        }catch(SQLException | ClassNotFoundException exception){
            System.out.println(exception);
        }
        return flights;
    }

    @Override
    public int insertFlight(Flight flight) {
        int rowInserted = 0;
        try {
            Connection connection = MySQLConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO FLIGHTS VALUES (%d, '%s', '%s', '%s', '%s', %d)" ,flight.getFlightID(), flight.getDestCountry(), flight.getDepartCountry(), flight.getDestAirport(), flight.getDepartAirport(), flight.getCapacity());
            rowInserted = statement.executeUpdate(query);
        }
        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        return rowInserted;
    }

    @Override
    public int UpdateFlight(int flightID, Flight flight) {
        int rowUpdated = 0;
        try {
            Connection connection = MySQLConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            String query = String.format("UPDATE FLIGHTS SET DEST_COUNTRY = %s, DEPART_COUNTRY = %s, DEST_AIRPORT = %s, DEPART_AIRPORT = %s, CAPACITY = %d WHERE FLIGHT_ID = %d" , flight.getDestCountry(), flight.getDepartCountry(), flight.getDestAirport(), flight.getDepartAirport(), flight.getCapacity(), flightID);
            rowUpdated = statement.executeUpdate(query);
        }
        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        return rowUpdated;
    }

    @Override
    public int DeleteFlightPreparedStatement(int flightID) {
        int rowDeleted = 0;
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FLIGHTS WHERE FLIGHT_ID = ?");
            preparedStatement.setInt(1, flightID);

            rowDeleted = preparedStatement.executeUpdate();
            System.out.println("Inserted : " + rowDeleted);
            return rowDeleted;
        }
        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        return rowDeleted;
    }

    @Override
    public Flight getFlight(int flightID) {
        Flight flight = null;
        try {
            Connection connection = MySQLConnectionUtil.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM FLIGHTS WHERE FLIGHT_ID=%d", flightID));
            if (resultSet.next()) {
                flight = new Flight(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getInt(6));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flight;
    }
}
