package ats.ui;

import java.util.ArrayList;

import model.booking.Booking;
import service.booking.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to ATS!");
        //TestGetBooking();
        TestInsertBooking();
    }
    
    private static void TestGetBooking() {
    	 
    	BookingService bookingService = new BookingServiceImpl();
    	ArrayList<Booking> bookings = bookingService.getBookings();
    	bookings.forEach(booking -> System.out.println(booking));
		
    }
    
    private static void TestInsertBooking() {
   	 
    	BookingService bookingService = new BookingServiceImpl();
    	bookingService.insertBooking(new Booking(4,"John","2021,07,02","Singapore","South Korea","E6",1500.0f));
		
    }
}
