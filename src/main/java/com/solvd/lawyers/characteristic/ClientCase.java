package com.solvd.lawyers.characteristic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.time.Period;

public class ClientCase{

    private static final Logger LOGGER = LogManager.getLogger(ClientCase.class);

    private String description;

    public ClientCase(String description) {
        this.description = description;
    }

    public void caseWaiting(LocalDate prevDate) {
        LocalDate now = LocalDate.now();
        Period period = Period.between(prevDate, now);

        LOGGER.info("Event waiting for: years: " + period.getYears() + " , months: " + period.getMonths() + ", days: " + period.getDays());
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
