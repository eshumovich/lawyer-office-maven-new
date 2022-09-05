package com.solvd.lawyers.characteristic;

import com.solvd.lawyers.Address;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Lawyer {

    private static final Logger LOGGER = LogManager.getLogger(Lawyer.class);

    private static int quantityLawyers;

    private String name;
    private Address address;
    private LocalDate birth;
    private int rating;
    private BigDecimal salary;

    public Lawyer(String name, Address address, LocalDate birth) {
        this.name = name;
        this.address = address;
        this.birth = birth;
        quantityLawyers++;
    }

    public void provideDefendence(Client client) {
        LOGGER.info(getName() + " provides defendence to a " + " Name");
        client.payLawyer(getSalary());
    }

    public void enterUniversity() {
        LOGGER.info("entered the Harvard University");
    }

    public static int getQuantityLawyers() {
        return quantityLawyers;
    }

    public static void setQuantityLawyers(int quantityLawyers) {
        Lawyer.quantityLawyers = quantityLawyers;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }
}


