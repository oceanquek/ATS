package ats.ui;

import java.util.ArrayList;

import javax.naming.Context;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import model.booking.Booking;
import service.booking.*;

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to ATS!");
        //TestGetBooking();
        //TestInsertBooking();
        //testIOC();
        testBookingId();
    }
    
    private static void testBookingId() {
    	BookingService bookingService = new BookingServiceImpl();
    	System.out.println(bookingService.getBookingByBookingId(2).getCustomerName());
	}
    private static void TestGetBooking() {
    	 
    	BookingService bookingService = new BookingServiceImpl();
    	ArrayList<Booking> bookings = bookingService.getBookings();
    	bookings.forEach(booking -> System.out.println(booking));
		
    }
    
    private static void TestInsertBooking() {
   	 
    	BookingService bookingService = new BookingServiceImpl();
    	bookingService.insertBooking(new Booking(5,"John","2021,07,02","Singapore","South Korea","E6",1500.0f));
		
    }
    private static void testIOC() {
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    	BookingService bookingService = context.getBean("bookingService", BookingService.class);
		bookingService.getBookings().forEach(System.out::println);
    }
}
