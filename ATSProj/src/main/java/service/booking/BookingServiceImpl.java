package service.booking;

import java.util.ArrayList;

import model.booking.Booking;
import repository.booking.BookingRepositoryImpl;


public class BookingServiceImpl implements BookingService {
	BookingRepositoryImpl bookingRepository;

	public BookingServiceImpl() {
		// TODO Auto-generated constructor stub
		System.out.println("Booking service instantiated");
		bookingRepository = new BookingRepositoryImpl();
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

}
