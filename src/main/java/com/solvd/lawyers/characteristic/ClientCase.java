package com.solvd.lawyers.characteristic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import java.time.LocalDate;
import java.time.Period;

@XmlAccessorType(XmlAccessType.FIELD)
public class ClientCase{

    private static final Logger LOGGER = LogManager.getLogger(ClientCase.class);

    private String description;

    public ClientCase(String description) {
        this.description = description;
    }

    public ClientCase() {
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

    @Override
    public String toString() {
        return "ClientCase{" +
                "description='" + description + '\'' +
                '}';
    }
}
