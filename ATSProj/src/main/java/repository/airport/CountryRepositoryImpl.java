package repository.airport;

import model.airports.Country;
import util.MySQLConnectionUtil;

import java.sql.*;
import java.util.ArrayList;

public class CountryRepositoryImpl implements CountryRepository{
    String DB_NAME = "ATS";
    String USER_NAME = "root";
    String PASSWORD = "P@ssw0rd";

    public CountryRepositoryImpl() {
    }

    private Connection iniConnection() {
        return MySQLConnectionUtil.getConnection(DB_NAME, USER_NAME, PASSWORD);
    }
    @Override
    public Country getCountry(Country country) {
        Connection connection = iniConnection();
        Country result = new Country();
        try {
            String query = "SELECT * FROM COUNTRY WHERE COUNTRY_ID=?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, country.getCountryID());
            // execute the preparedstatement
            ResultSet resultSet = preparedStmt.executeQuery();
            while (resultSet.next()) {
                result.setCountryID(resultSet.getInt(1));
                result.setCountryName(resultSet.getString(2));
                result.setCountryCity(resultSet.getString(3));
                result.setCountryState(resultSet.getString(4));
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
        return result;
    }

    @Override
    public ArrayList<Country> getCountryList() {
        ArrayList<Country> countryArrayList = new ArrayList<Country>();
        Connection connection = iniConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM COUNTRY");
            while (resultSet.next()) {
                Country country = new Country();
                country.setCountryID(resultSet.getInt(1));
                country.setCountryName(resultSet.getString(2));
                country.setCountryCity(resultSet.getString(3));
                country.setCountryState(resultSet.getString(4));
                countryArrayList.add(country);

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
        return countryArrayList;
    }

    @Override
    public int insertCountry(Country country) {
        int noOfRowsInserted = 0;
        Connection connection = iniConnection();
        try {
            String query = " INSERT INTO COUNTRY (COUNTRY_NAME,CITY,STATE)"
                    + " values (?, ?,?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, country.getCountryName());
            preparedStmt.setString(2, country.getCountryCity());
            preparedStmt.setString(3, country.getCountryState());

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
    public int deleteCountry(Country country) {
        Connection connection = iniConnection();
        int noOfRowsDeleted = 0;
        try {
            String query = " DELETE FROM COUNTRY WHERE COUNTRY_ID=?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, country.getCountryID());
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
    public int updateCountry(Country country) {
        Connection connection = iniConnection();
        int noOfRowsUpdated = 0;
        try {
            String query = " UPDATE COUNTRY SET COUNTRY_NAME=?,CITY=?,STATE=? WHERE COUNTRY_ID=?;";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, country.getCountryName());
            preparedStmt.setString(2, country.getCountryCity());
            preparedStmt.setString(3, country.getCountryState());
            preparedStmt.setInt(4, country.getCountryID());
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
