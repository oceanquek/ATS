package model.booking;

import java.sql.Date;

public class Booking {
	private String CustomerName;
	private Date dateOfFlight;
	private String departure;
	private String Destination;
	private int bookingId;
	private String seatNo;
	private float CostofFlight;
	
	// Default constructor
	public Booking (){
		
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public float getCostofFlight() {
		return CostofFlight;
	}
	public void setCostofFlight(float costofFlight) {
		CostofFlight = costofFlight;
	}
	public Date getDateOfFlight() {
		return dateOfFlight;
	}
	public void setDateOfFlight(Date dateOfFlight) {
		this.dateOfFlight = dateOfFlight;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	
	@Override
	public String toString() {
		String productString = "\nBooking Id : " + getBookingId() +
				"\tCustomer name : \t" + getCustomerName() + "\t" +
				"Price : " + getCostofFlight()+"\n";
		return productString;
	}
}
