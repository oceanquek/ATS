package com.domain.controller;

import java.util.List;
import java.util.Optional;

import javax.swing.colorchooser.ColorSelectionModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.domain.entity.Booking;
import com.domain.repository.BookingRepository;
import com.domain.utility.Colors;

@RestController
//http://localhost:8080/ecz/api
@RequestMapping("/api")
public class BookingController {
	@Autowired
	BookingRepository bookingRepository;
	
	@GetMapping("/bookings")
	public List<Booking> findAllBookings() {
		List<Booking> bookingsList =  bookingRepository.findAll();
		bookingsList.forEach(Colors::pc);
		return bookingsList;
	}
	
	@GetMapping("/bookings/{id}")
	public Booking findBookingById(@PathVariable(value="id") Long bookingId) {
		Optional<Booking> optionalBooking =  bookingRepository.findById(bookingId);
		Booking booking = optionalBooking.get();
		Colors.pc(booking);
		return booking;
	}
	
	@PostMapping("/bookings")
	public Booking createBooking(@RequestBody Booking booking) {
		Colors.pc("inserting "+ booking);
		Booking bookingReturned = bookingRepository.save(booking);
		Colors.pc("inserted "+ booking);
		return booking;
	}
	@PutMapping("/bookings/{id}")
	public Booking updateBooking(@PathVariable(value="id") Long bookingId, @RequestBody Booking booking) {
		Optional<Booking> optionalBookingOptional = bookingRepository.findById(bookingId);
		Booking bookingFromDbBooking = optionalBookingOptional.get();
		bookingFromDbBooking.setCustomerName(booking.getCustomerName());
		bookingFromDbBooking.setDateOfFlight(booking.getDateOfFlight());
		bookingFromDbBooking.setDeparture(booking.getDeparture());
		bookingFromDbBooking.setDestination(booking.getDestination());
		bookingFromDbBooking.setSeatNo(booking.getSeatNo());
		bookingFromDbBooking.setCostofFlight(booking.getCostofFlight());
		Booking bookingReturn = bookingRepository.save(bookingFromDbBooking);
		Colors.pc("updated " + booking);
		return booking;
	}
	
	@DeleteMapping("/bookings/{id}")
	public boolean deleteBooking(@PathVariable(value="id") Long bookingId) {
		bookingRepository.deleteById(bookingId);
		Colors.pc("Deleted" + bookingId);
		return true;
	}

}