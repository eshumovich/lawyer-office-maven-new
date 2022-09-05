package com.solvd.lawyers.characteristic;

import com.solvd.lawyers.worktime.VisitTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.Objects;

public class Service {

    private static final Logger LOGGER = LogManager.getLogger(Service.class);

    private VisitTime visitTime;
    private String descriptionOfService;

    public Service(String descriptionOfService) {
        this.descriptionOfService = descriptionOfService;
    }

    public Service(VisitTime visitTime) {
        super();
        this.visitTime = visitTime;
    }

    public String getDescriptionOfService() {
        return descriptionOfService;
    }

    public void setDescriptionOfService(String descriptionOfService) {
        this.descriptionOfService = descriptionOfService;
    }

    public VisitTime getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(VisitTime visitTime) {
        this.visitTime = visitTime;
    }
}
