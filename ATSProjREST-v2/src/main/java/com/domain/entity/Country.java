package com.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "COUNTRY")
public class Country {
    @Id
    @Column(name = "COUNTRY_ID")
    private int countryID;
    @Column(name = "COUNTRY_NAME")
    private String countryName;
    @Column(name = "CITY")
    private String countryCity;
    @Column(name = "STATE")
    private String countryState;


    public Country(int countryID) {
        this.countryID =countryID;
    }
    public Country(String countryName, String countryCity, String countryState) {
        this.countryName = countryName;
        this.countryCity = countryCity;
        this.countryState = countryState;
    }



}
