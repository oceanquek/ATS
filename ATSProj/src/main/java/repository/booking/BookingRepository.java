package repository.booking;

import java.util.ArrayList;

import model.booking.Booking;

public interface BookingRepository {
	public ArrayList<Booking> getBookings();
	public int insertBookingPreparedStatement(Booking Booking);
	public int UpdateBookingPreparedStatement(Booking Booking);
	public int DeleteBookingPreparedStatement(int BookingId);
}
