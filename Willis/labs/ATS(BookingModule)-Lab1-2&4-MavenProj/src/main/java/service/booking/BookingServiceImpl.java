package service.booking;

import java.util.ArrayList;

import model.booking.Booking;
import repository.booking.BookingRepositoryImpl;


public class BookingServiceImpl implements BookingService {
	BookingRepositoryImpl bookingRepository;

	public BookingServiceImpl() {
		this.bookingRepository = new BookingRepositoryImpl();
	}
	
	public void setBookingRepository(BookingRepositoryImpl bookingRepository) {
		this.bookingRepository = bookingRepository;
	}


	public ArrayList getBookings(){
		return bookingRepository.getBookings();
	}
	public int insertBooking(Booking booking)
	{

		return bookingRepository.insertBookingPreparedStatement(booking);
	}
	public int updateBooking(Booking booking)
	{

		return bookingRepository.UpdateBookingPreparedStatement(booking);
	}
	
	public int deleteBooking(Booking booking)
	{

		return bookingRepository.DeleteBookingPreparedStatement(booking.getBookingId());
	}
	public Booking getBookingByBookingId(int bookingId) {
		
		return bookingRepository.getBookingByBookingId(bookingId);
	}
	public Booking getBookingByCustomerName(String name) {
		return bookingRepository.getBookingByCustomerName(name);
	}

}
