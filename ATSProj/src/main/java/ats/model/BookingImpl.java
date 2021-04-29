package ats.model;

public class BookingImpl implements Booking {
	private String dateOfFlight;
	private String departure;
	private String Destination;
	private int bookingId;
	private String seatNo;
	private int Planeid;
	private float CostofFlight;
	
	// Default constructor
	public BookingImpl (){
		
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
	public int getPlaneid() {
		return Planeid;
	}
	public void setPlaneid(int planeid) {
		Planeid = planeid;
	}
	public float getCostofFlight() {
		return CostofFlight;
	}
	public void setCostofFlight(float costofFlight) {
		CostofFlight = costofFlight;
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
		return Destination;
	}
	public void setDestination(String destination) {
		Destination = destination;
	}
	
	public Booking getBooking(){
		return this;
	}
}
