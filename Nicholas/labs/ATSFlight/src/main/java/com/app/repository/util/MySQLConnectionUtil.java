package com.app.repository.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnectionUtil {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			// getting connected it returns a connection interface
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atsdb", "root",
					"wY53bzrt");
			System.out.println("Connected!!");
			return connection;
		} catch (ClassNotFoundException | SQLException exception) {
			// TODO Auto-generated catch block
			System.out.println(exception);
			return null;
		}
	}
}
