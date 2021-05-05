package com.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AIRPORT")
//@NamedQuery(name = "Airport.findAirportByCode",
//        query = "SELECT * FROM AIRPORT WHERE CODE=?1")
public class Airport {
    @Id
    @Column(name = "AIRPORT_ID")
    private int airportID;
    @Column(name = "CODE")
    private String airportCode;
    @Column(name = "NAME")
    private String airportName;
    @Column(name = "COUNTRY_ID")
    private int countryID;

    public Airport(int airportID) {
        this.airportID = airportID;
    }

    public Airport(String airportCode, String airportName, int countryID) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.countryID = countryID;
    }


}
