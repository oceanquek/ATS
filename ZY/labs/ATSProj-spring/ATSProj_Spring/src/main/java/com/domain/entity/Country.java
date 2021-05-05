package com.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COUNTRY_V2")
public class Country {
    @Id
    @Column(name = "COUNTRY_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int countryID;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Column(name = "CITY")
    private String countryCity;
    @Column(name = "STATE")
    private String countryState;

    @OneToMany(mappedBy="country")
    private Set<Airport> airportSet;

    public Country(int countryID) {
        this.countryID =countryID;
    }
    public Country(String countryName, String countryCity, String countryState) {
        this.countryName = countryName;
        this.countryCity = countryCity;
        this.countryState = countryState;
    }



}
