package com.solvd.lawyers.characteristic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Service {

    private static final Logger LOGGER = LogManager.getLogger(Service.class);

    private String descriptionOfService;

    public Service(String descriptionOfService) {
        this.descriptionOfService = descriptionOfService;
    }

    public Service() {
    }

    public String getDescriptionOfService() {
        return descriptionOfService;
    }

    public void setDescriptionOfService(String descriptionOfService) {
        this.descriptionOfService = descriptionOfService;
    }

    @Override
    public String toString() {
        return "Service{" +
                ", descriptionOfService='" + descriptionOfService + '\'' +
                '}';
    }
}
