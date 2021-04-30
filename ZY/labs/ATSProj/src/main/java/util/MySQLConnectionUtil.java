package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtil {
    public static Connection getConnection(String dbName,String userName,String password)  {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbName,userName,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }
}
