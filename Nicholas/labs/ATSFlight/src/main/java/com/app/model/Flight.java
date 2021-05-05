package com.app.model;

public class Flight {
    private int flightID;
    private String destCountry;
    private String departCountry;
    private String destAirport;
    private String departAirport;
    private int capacity;

    public Flight(){};

    public Flight(int flightID, String destCountry, String departCountry, String destAirport, String departAirport, int capacity){
        this.flightID = flightID;
        this.destCountry = destCountry;
        this.departCountry = departAirport;
        this.destAirport = destAirport;
        this.departAirport = departAirport;
        this.capacity = capacity;
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightID) {
        this.flightID = flightID;
    }

    public String getDestCountry() {
        return destCountry;
    }

    public void setDestCountry(String destCountry) {
        this.destCountry = destCountry;
    }

    public String getDepartCountry() {
        return departCountry;
    }

    public void setDepartCountry(String departCountry) {
        this.departCountry = departCountry;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }

    public String getDepartAirport() {
        return departAirport;
    }

    public void setDepartAirport(String departAirport) {
        this.departAirport = departAirport;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
