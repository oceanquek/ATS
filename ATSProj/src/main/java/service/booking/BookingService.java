package service.booking;

import java.util.ArrayList;

import model.booking.Booking;

public interface BookingService {
	public ArrayList getBookings();
	public int insertBooking(Booking booking);
	public int updateBooking(Booking booking);
	public int deleteBooking(Booking booking);
}
