package repository.flight;

import exception.FlightNotAvailableException;
import model.flights.Flight;
import util.MySQLConnectionUtil;

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
    public int insertFlightPreparedStatement(Flight flight) {
        int rowInserted = 0;
        try {
            Connection connection = MySQLConnectionUtil.getConnection();
            // prepared statement for executing a query
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO FLIGHTS VALUES(?,?,?,?,?,?)");
//			Perform insert DML
            preparedStatement.setInt(1, 2);
            preparedStatement.setString(2, "Singapore");
            preparedStatement.setString(3, "Hong Kong");
            preparedStatement.setString(4, "Changi International Airport");
            preparedStatement.setString(5, "Hong Kong International Airport");
            preparedStatement.setInt(6, 200);

            rowInserted = preparedStatement.executeUpdate();
            System.out.println("Inserted : " + rowInserted);
            return rowInserted;
        }
        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        return rowInserted;
    }

    @Override
    public int UpdateFlightPreparedStatement(Flight flight) {
        int rowUpdated = 0;
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            // prepared statement for executing a query
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE FLIGHTS SET CAPACITY = ? WHERE FLIGHT_ID = ?");
//			Perform insert DML
            preparedStatement.setInt(1, 300);
            preparedStatement.setInt(2, flight.getFlightID());

            rowUpdated = preparedStatement.executeUpdate();
            System.out.println("Inserted : " + rowUpdated);
            return rowUpdated;
        }
        catch (SQLException | ClassNotFoundException exception) {
            System.out.println(exception);
        }
        return rowUpdated;
    }

    @Override
    public int DeleteFlightPreparedStatement(Flight flight) {
        int rowDeleted = 0;
        try{
            Connection connection = MySQLConnectionUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM FLIGHTS WHERE FLIGHT_ID = ?");
            preparedStatement.setInt(1, flight.getFlightID());

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
    public Flight getFlight(Flight flight) {
        Flight firstFlight = new Flight(1, "Hong Kong", "Singapore", "Hong Kong International Airport", "Changi International Airport", 200);
        try{

        }catch(NullPointerException nullPointerException){
            System.out.println("Log : " + nullPointerException);
            System.out.println("Hi, please try after some time.");
        }
        try{
            if (firstFlight == null){
                FlightNotAvailableException flightNotAvailableException = new FlightNotAvailableException();
                throw flightNotAvailableException;
            }
        }catch (FlightNotAvailableException flightNotAvailableException){
            System.out.println("Sorry, the flight you are looking for does not exist.");
        }
        return null;
    }
}
