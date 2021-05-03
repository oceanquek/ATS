package app.repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import app.model.Plane;
import app.repository.util.MySQLConnection;

public class PlaneRepositoryImpl implements PlaneRepository {
    @Override
    public ArrayList getPlanes() {
        Connection connection = MySQLConnection.getConnection("ATS","root","mysql");
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PLANES");
            while (resultSet.next()) {
                planes.add(new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5)));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return planes;
    }

    @Override
    public Plane getPlane(int planeID) {
        Plane plane = null;

        Connection connection = MySQLConnection.getConnection("ATS","root","mysql");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM PLANES WHERE PLANE_ID=%d",planeID));
            if (resultSet.next()) {
                plane = new Plane(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4),resultSet.getString(5));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return plane;
    }

    @Override
    public int insertPlane(Plane plane) {
        int rows = 0;
        Connection connection = MySQLConnection.getConnection("ATS","root","mysql");
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO PLANES VALUES (%d,'%s','%s',%d,'%s')",plane.getId(),plane.getPlaneMaker(),plane.getPlaneModel(),plane.getPlaneCapacity(),plane.getPlaneRegNo());
            rows = statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }

    @Override
    public int updatePlane(int id,Plane plane) {
        int rows = 0;
        Connection connection = MySQLConnection.getConnection("ATS","root","mysql");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PLANES SET PLANE_MAKER=?, PLANE_MODEL=?, CAPACITY=?, REG_NO=?  WHERE PLANE_ID=?");
            preparedStatement.setString(1,plane.getPlaneMaker());
            preparedStatement.setString(2,plane.getPlaneModel());
            preparedStatement.setInt(3,plane.getPlaneCapacity());
            preparedStatement.setString(4,plane.getPlaneRegNo());
            preparedStatement.setInt(5,id);
            rows = preparedStatement.executeUpdate();
        } catch (SQLException ex) {

        }
        return rows;
    }

    @Override
    public int deletePlane(int index) {
        int rows = 0;
        Connection connection = MySQLConnection.getConnection("ATS","root","mysql");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PLANES WHERE PLANE_ID=?");
            preparedStatement.setInt(1, index);
            rows = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return rows;
    }

    @Override
    public List<Plane> searchPlaneByRegNo(String regNo) {
        ArrayList<Plane> unfilteredPlanes = getPlanes();
        Stream<Plane> filteredStream = unfilteredPlanes.stream().filter(plane -> plane.getPlaneRegNo().equals(regNo));
        ArrayList<Plane> filteredPlanes = new ArrayList<>(filteredStream.collect(Collectors.toList()));

        return filteredPlanes;
    }

    @Override
    public List<Plane> searchPlaneByMaker(String maker) {
        ArrayList<Plane> unfilteredPlanes = getPlanes();
        Stream<Plane> filteredStream = unfilteredPlanes.stream().filter(plane -> plane.getPlaneMaker().equals(maker));
        ArrayList<Plane> filteredPlanes = new ArrayList<>(filteredStream.collect(Collectors.toList()));

        return filteredPlanes;
    }

    @Override
    public List<Plane> searchPlaneByModel(String model) {
        ArrayList<Plane> unfilteredPlanes = getPlanes();
        Stream<Plane> filteredStream = unfilteredPlanes.stream().filter(plane -> plane.getPlaneModel().equals(model));
        ArrayList<Plane> filteredPlanes = new ArrayList<>(filteredStream.collect(Collectors.toList()));

        return filteredPlanes;
    }
}
