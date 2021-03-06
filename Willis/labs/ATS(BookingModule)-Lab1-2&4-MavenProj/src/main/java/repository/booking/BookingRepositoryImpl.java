package repository.booking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import exception.BookingNotAvailableException;
import model.booking.Booking;
import util.MySQLConnectionUtil;

public class BookingRepositoryImpl implements BookingRepository {
	// functionality related to repository handling
	private String BookingName;

	// constructors are methods with same class name
	// purpose is to initialize the variables
	/// constructors without parameter is a default constructor
	// called automatically with new keyword
	public BookingRepositoryImpl() {
		System.out.println("Booking repository instantiated");
		BookingName = "Fullstack Development";
	}
	
	public String log(){
		return "cnv message";
	}
	
	public Booking getBookingByCustomerName(String name) {
		Booking booking = null;
		try {
			 Connection connection = MySQLConnectionUtil.getConnection();
			 // statement for executing a query
			 Statement statement = connection.createStatement();
			 //get the results
			 ResultSet resultSet = statement.executeQuery("Select * FROM Booking WHERE CUSTOMER_NAME = "+ "'" +name + "'");
			 while(resultSet.next()) {
				booking = new Booking(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
						 resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getFloat("COST"));
			 }
			 } catch (ClassNotFoundException | SQLException exception) {
			 // TODO Auto-generated catch block
			 System.out.println(exception);
			 }
		 
		
		return booking;
	}

	public Booking getBookingByBookingId(int bookingId) {
		
		Booking booking = null;
			try {
				 Connection connection = MySQLConnectionUtil.getConnection();
				 // statement for executing a query
				 Statement statement = connection.createStatement();
				 //get the results
				 ResultSet resultSet = statement.executeQuery("Select * FROM Booking WHERE BOOKING_ID ="+bookingId);
				 while(resultSet.next()) {
					booking = new Booking(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
							 resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getFloat("COST"));
				 }
				 } catch (ClassNotFoundException | SQLException exception) {
				 // TODO Auto-generated catch block
				 System.out.println(exception);
				 }
			 
			
			return booking;
	}

	public ArrayList<Booking> getBookings() {
		
		ArrayList Bookings = new ArrayList<Booking>();
		 try {
		 Connection connection = MySQLConnectionUtil.getConnection();
		 // statement for executing a query
		 Statement statement = connection.createStatement();
		 //get the results
		 ResultSet resultSet = statement.executeQuery("Select * FROM Booking");
		 while(resultSet.next()){
			 Bookings.add(new Booking(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3),
					 resultSet.getString(4),resultSet.getString(5),resultSet.getString(6), resultSet.getFloat("COST")));
		 }
		 } catch (ClassNotFoundException | SQLException exception) {
		 // TODO Auto-generated catch block
		 System.out.println(exception);
		 }
		 
		
		return Bookings;
	}
	

public int insertBookingPreparedStatement(Booking Booking){
		
	int noOfRowsInserted =0;
		try {
			 Connection connection = MySQLConnectionUtil.getConnection();
			 // statement for executing a query
			 PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Booking VALUES(?,?,?,?,?,?,?) ");
			 
			 preparedStatement.setInt(1, Booking.getBookingId());
			 preparedStatement.setString(2, Booking.getCustomerName());
			 preparedStatement.setString(3, Booking.getDateOfFlight());
			 preparedStatement.setString(4, Booking.getDeparture());
			 preparedStatement.setString(5, Booking.getDestination());
			 preparedStatement.setString(6, Booking.getSeatNo());
			 preparedStatement.setFloat(7, Booking.getCostofFlight());
				 //statement.executeQuery
				noOfRowsInserted = preparedStatement.executeUpdate();
			
			 } catch (ClassNotFoundException | SQLException exception) {
			 // TODO Auto-generated catch block
			 System.out.println(exception);
			 }
		return noOfRowsInserted;
	}
	
	
	
	public int UpdateBookingPreparedStatement(Booking Booking){
		
		int noOfRowsUpdated =0;
			try {
				 Connection connection = MySQLConnectionUtil.getConnection();
				 // statement for executing a query
				 PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Booking SET CUSTOMER_NAME =? , "
				 		+ "BOOKING_DATE =? , DEPARTURE=?, DESTINATION=?, SEAT_NO=?,COST=? WHERE Booking_ID =?");
				 
				 preparedStatement.setString(1, Booking.getCustomerName());
				 preparedStatement.setString(2, Booking.getDateOfFlight());
				 preparedStatement.setString(3, Booking.getDeparture());
				 preparedStatement.setString(4, Booking.getDestination());
				 preparedStatement.setString(5, Booking.getSeatNo());
				 preparedStatement.setFloat(6, Booking.getCostofFlight());
				 preparedStatement.setInt(7, Booking.getBookingId());
					 //statement.executeQuery
					noOfRowsUpdated = preparedStatement.executeUpdate();
				
				 } catch (ClassNotFoundException | SQLException exception) {
				 // TODO Auto-generated catch block
				 System.out.println(exception);
				 }
			return noOfRowsUpdated;
		}
	
	
public int DeleteBookingPreparedStatement(int BookingId){
		
		int noOfRowsDeleted =0;
			try {
				 Connection connection = MySQLConnectionUtil.getConnection();
				 // statement for executing a query
				 PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Booking WHERE Booking_ID = ?");
				 
				 preparedStatement.setInt(1, BookingId);
					 //statement.executeQuery
					noOfRowsDeleted = preparedStatement.executeUpdate();
				
				 } catch (ClassNotFoundException | SQLException exception) {
				 // TODO Auto-generated catch block
				 System.out.println(exception);
				 }
			return noOfRowsDeleted;
		}
}
