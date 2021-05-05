package com.domain.entity;

import javax.persistence.*;

@Entity
@Table(name="FLIGHTS")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FLIGHT_ID")
    private long id;
    @Column(name = "DEST_COUNTRY")
    private String destCountry;
    @Column(name = "DEPART_COUNTRY")
    private String departCountry;
    @Column(name = "DEST_AIRPORT")
    private String destAirport;
    @Column(name = "DEPART_AIRPORT")
    private String = departAirport;
    @Column(name = "CAPACITY")
    private int = capacity;

    public Flight(){
    }

    public Flight(String destCountry, String departCountry, String destAirport, String departAirport, int capacity) {
        this.destCountry = destCountry;
        this.departCountry = departCountry;
        this.destAirport = destAirport;
        this.departAirport = departAirport;
        this.capacity = capacity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
