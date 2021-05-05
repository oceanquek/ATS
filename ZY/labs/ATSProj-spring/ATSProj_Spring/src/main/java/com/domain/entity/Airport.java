package com.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "AIRPORT_V2")
public class Airport {
    @Id
    @Column(name = "AIRPORT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int airportID;
    @Column(name = "CODE")
    private String airportCode;
    @Column(name = "NAME")
    private String airportName;
//    @Column(name = "COUNTRY_ID")
//    @JoinColumn(name = "country_country_id", referencedColumnName = "AIRPORT_ID")
//    private int countryID;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "country_id")
    private Country country;

    public Airport(int airportID) {
        this.airportID = airportID;
    }

//    public Airport(String airportCode, String airportName, int countryID) {
//        this.airportCode = airportCode;
//        this.airportName = airportName;
//        this.countryID = countryID;
//    }


    public Airport(String airportCode, String airportName, Country country) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.country = country;
    }
}
