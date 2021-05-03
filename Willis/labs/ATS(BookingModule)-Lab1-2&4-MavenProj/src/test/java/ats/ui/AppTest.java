package ats.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.booking.Booking;
import service.booking.BookingService;
import service.booking.BookingServiceImpl;



public class AppTest {
	@Test
	//Get selection of all bookings
	public void testGetBooking() {
		BookingService bookingService = new BookingServiceImpl();
    	ArrayList<Booking> bookings = bookingService.getBookings();
		assertEquals(bookings.size(),bookingService.getBookings().size());

	}
	
	@Test
	//Select booking by booking id
	public void testGetBookingByBookingId () {
		BookingService bookingService = new BookingServiceImpl();
		assertEquals("DAVID", bookingService.getBookingByBookingId(1).getCustomerName());
	}
	
	@Test
	//Search by firstname
	public void testGetBookingByFirstName() {
		BookingService bookingService = new BookingServiceImpl();
		assertEquals(3, bookingService.getBookingByCustomerName("JEAN").getBookingId());
	}
	
	@Test
	//Insert booking
	public void testBookingInsertion() {
		BookingService bookingService = new BookingServiceImpl();
		Booking booking = new Booking(9,"John","2021,07,02","Singapore","South Korea","E6",1500.0f);
		assertEquals(1,bookingService.insertBooking(booking));
		assertNotEquals(1,bookingService.insertBooking(booking));
		bookingService.deleteBooking(booking);
		
	}
	
	@Test
	//Delete booking
	public void testBookingDeletion() {
		BookingService bookingService = new BookingServiceImpl();
		Booking booking = new Booking(8,"John","2021,07,02","Singapore","South Korea","E6",1500.0f);
		bookingService.insertBooking(booking);
		assertEquals(1,bookingService.deleteBooking(booking));
		assertNotEquals(1,bookingService.deleteBooking(booking));

	}
	
	@Test
	//Update booking
	public void testBookingUpdate() {
		BookingService bookingService = new BookingServiceImpl();
		Booking booking = new Booking(10,"John","2021,07,02","Singapore","South Korea","E6",1500.0f);
		bookingService.insertBooking(booking);
		booking.setCustomerName("Jacob");
		assertEquals(1,bookingService.updateBooking(booking));
		//bookingService.deleteBooking(booking);
		//assertNotEquals(1,bookingService.updateBooking(booking));

	}
}
