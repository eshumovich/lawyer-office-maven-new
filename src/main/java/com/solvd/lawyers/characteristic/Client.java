package com.solvd.lawyers.characteristic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class Client {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private ClientCase clientCase;
    private BigDecimal money;

    public Client(ClientCase clientCase, BigDecimal money) {
        this.clientCase = clientCase;
        this.money = money;
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
}

