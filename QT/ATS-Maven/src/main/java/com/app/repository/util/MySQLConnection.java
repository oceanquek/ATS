package com.app.repository.util;

import java.sql.*;

public class MySQLConnection {

    public static Connection getConnection(String dbName,String userName,String password) {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName,userName,password);
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }

        return connection;
    }

    public void getQuery(Connection connection) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM PRODUCTS");
            while (resultSet.next()) {
                System.out.println(String.format("%s %s %s",resultSet.getInt(1),resultSet.getString(2),resultSet.getFloat("price")));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

}
