package com.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BOOKINGS")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	@Column(name = "CUSTOMER_NAME", nullable = false)
	private String CustomerName;
	private String dateOfFlight;
	private String departure;
	private String destination;
	private String seatNo;
	private float CostofFlight;

	public Booking() {
		
	}



	public Booking(Long bookingId, String customerName, String dateOfFlight, String departure, String destination,
			String seatNo, float costofFlight) {
		super();
		this.bookingId = bookingId;
		CustomerName = customerName;
		this.dateOfFlight = dateOfFlight;
		this.departure = departure;
		this.destination = destination;
		this.seatNo = seatNo;
		CostofFlight = costofFlight;
	}



	

	public Long getBookingId() {
		return bookingId;
	}



	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}



	public String getCustomerName() {
		return CustomerName;
	}



	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}



	public String getDateOfFlight() {
		return dateOfFlight;
	}



	public void setDateOfFlight(String dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}



	public String getDeparture() {
		return departure;
	}



	public void setDeparture(String departure) {
		this.departure = departure;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	public String getSeatNo() {
		return seatNo;
	}



	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}



	public float getCostofFlight() {
		return CostofFlight;
	}



	public void setCostofFlight(float costofFlight) {
		CostofFlight = costofFlight;
	}



	@Override
	public String toString() {
		String productString = "\nBooking Id : " + getBookingId() +
				"\tCustomer name : \t" + getCustomerName() + "\t" +
				"Price : " + getCostofFlight()+"\n";
		return productString;
	}
}