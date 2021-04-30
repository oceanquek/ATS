package repository.plane;

import model.planes.Plane;
import java.sql.*;
import java.util.ArrayList;

public class PlaneRepositoryImpl implements PlaneRepository {
    @Override
    public ArrayList getPlanes() {
        Connection connection = util.MySQLConnectionUtil.getConnection("planes","root","mysql");
        ArrayList<Plane> planes = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PLANES");
            while (resultSet.next()) {
                planes.add(new Plane());
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return planes;
    }

    @Override
    public Plane getPlane(int planeID) {
        Plane plane = null;

        Connection connection = util.MySQLConnectionUtil.getConnection("planes","root","mysql");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(String.format("SELECT * FROM PLANE WHERE ID=%d",plane));
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
        Connection connection = util.MySQLConnectionUtil.getConnection("planes","root","mysql");
        try {
            Statement statement = connection.createStatement();
            String query = String.format("INSERT INTO PRODUCTS VALUES (%d,%s,%s,%d)",plane.getId(),plane.getPlaneMaker(),plane.getPlaneModel(),plane.getPlaneCapacity(),plane.getPlaneRegNo());
            rows = statement.executeUpdate(query);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return rows;
    }

    @Override
    public int updatePlane(int id,Plane plane) {
        int rows = 0;
        Connection connection = util.MySQLConnectionUtil.getConnection("planes","root","mysql");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PLANES SET PLANE_MAKER=?, PLANE_MODEL=?, PLANE_CAPACITY=?, PLANE_REGNO=?  WHERE ID=?");
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
        Connection connection = util.MySQLConnectionUtil.getConnection("planes","root","mysql");
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PRODUCTS WHERE PRODUCT_ID=?");
            preparedStatement.setInt(1, index);
            rows = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return rows;
    }
}
