package com.solvd.lawyers.characteristic;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.solvd.lawyers.parse.BigDecimalAdapterJaxb;
import com.solvd.lawyers.parse.BigDecimalDeserializerJson;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;

@XmlAccessorType(XmlAccessType.FIELD)
public class Client {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private ClientCase clientCase;
    @XmlJavaTypeAdapter(BigDecimalAdapterJaxb.class)
    @JsonDeserialize(using = BigDecimalDeserializerJson.class)
    private BigDecimal money;

    public Client(ClientCase clientCase, BigDecimal money) {
        this.clientCase = clientCase;
        this.money = money;
    }

    public Client() {
    }

    public void payLawyer(BigDecimal amount) {
        this.money = money.subtract(amount);
        LOGGER.info("Name" + " has remained: " + money + "$ after lawyers services");
    }

    public ClientCase getClientCase() {
        return clientCase;
    }

    public void setClientCase(ClientCase clientCase) {
        this.clientCase = clientCase;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientCase=" + clientCase +
                ", money=" + money +
                '}';
    }
}

