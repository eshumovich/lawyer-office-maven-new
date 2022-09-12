package com.solvd.lawyers.characteristic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.lawyers.Address;
import com.solvd.lawyers.parse.BigDecimalAdapterJaxb;
import com.solvd.lawyers.parse.BigDecimalDeserializerJson;
import com.solvd.lawyers.parse.LocalDateAdapterJaxb;
import com.solvd.lawyers.parse.LocalDateDeserializerJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.time.LocalDate;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Lawyer {

    private static final Logger LOGGER = LogManager.getLogger(Lawyer.class);

    private static int quantityLawyers;

    @XmlAttribute
    private String name;
    private Address address;
    private int rating;

    @XmlJavaTypeAdapter(LocalDateAdapterJaxb.class)
    @JsonDeserialize(using = LocalDateDeserializerJson.class)
    private LocalDate birthday;

    @XmlJavaTypeAdapter(BigDecimalAdapterJaxb.class)
    @JsonDeserialize(using = BigDecimalDeserializerJson.class)
    private BigDecimal salary;

    public Lawyer(String name, Address address, LocalDate birthday) {
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        quantityLawyers++;
    }

    public Lawyer() {
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

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lawyer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", rating=" + rating +
                ", birthday=" + birthday +
                ", salary=" + salary +
                '}';
    }
}


