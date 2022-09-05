package com.solvd.lawyers;

import java.util.Objects;

public class Address {

    private String country;
    private String city;
    private Integer houseNumber;

    public Address(String country, String city, Integer houseNumber) {
        this.country = country;
        this.city = city;
        this.houseNumber = houseNumber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }
}
