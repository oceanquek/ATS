package repository.airport;

import model.airports.Airport;
import util.MySQLConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class AirportRepositoryImpl implements AirportRepository {
    String DB_NAME = "ATS";
    String USER_NAME = "root";
    String PASSWORD = "P@ssw0rd";

    public AirportRepositoryImpl() {

    }

    private Connection iniConnection() {
        return MySQLConnectionUtil.getConnection(DB_NAME, USER_NAME, PASSWORD);
    }

    @Override
    public Airport getAirport() {
        Connection connection = iniConnection();
        Airport airport = new Airport();
        try {
            String query = "SELECT * FROM AIRPORT AIRPORT_ID=?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, airport.getAirportID());
            // execute the preparedstatement
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                airport.setAirportID(resultSet.getInt(1));
                airport.setAirportCode(resultSet.getString(2));
                airport.setAirportName(resultSet.getString(3));
                airport.setCountryID(resultSet.getInt(4));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return airport;
    }

    @Override
    public ArrayList<Airport> getAirportList() {
        ArrayList<Airport> airportArrayList = new ArrayList<Airport>();
        Connection connection = iniConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM AIRPORT");
            while (resultSet.next()) {
                Airport airport = new Airport();
                airport.setAirportID(resultSet.getInt(1));
                airport.setAirportCode(resultSet.getString(2));
                airport.setAirportName(resultSet.getString(3));
                airport.setCountryID(resultSet.getInt(4));
                airportArrayList.add(airport);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return airportArrayList;
    }

    @Override
    public int insertAirport(Airport airport) {
        int noOfRowsInserted = 0;
        Connection connection = iniConnection();
        try {
            String query = " INSERT INTO AIRPORT (CODE,NAME,COUNTRY_ID)"
                    + " values (?, ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, airport.getAirportCode());
            preparedStmt.setString(2, airport.getAirportName());
            preparedStmt.setInt(3, airport.getCountryID());

            // execute the preparedstatement
            noOfRowsInserted = preparedStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return noOfRowsInserted;
    }

    @Override
    public int deleteAirport(Airport airport) {
        Connection connection = iniConnection();
        int noOfRowsDeleted = 0;
        try {
            String query = " DELETE FROM AIRPORT WHERE AIRPORT_ID=?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, airport.getAirportID());
            // execute the preparedstatement
            noOfRowsDeleted = preparedStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return noOfRowsDeleted;
    }

    @Override
    public int updateAirport(Airport airport) {
        Connection connection = iniConnection();
        int noOfRowsUpdated = 0;
        try {
            String query = " UPDATE AIRPORT SET CODE=?,NAME=?,COUNTRY_ID=? WHERE AIRPORT_ID=?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, airport.getAirportCode());
            preparedStmt.setString(2, airport.getAirportName());
            preparedStmt.setInt(3, airport.getCountryID());
            // execute the preparedstatement
            noOfRowsUpdated = preparedStmt.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return noOfRowsUpdated;
    }
}
