package com.solvd.lawyers.characteristic;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class Staff {

    private static final Logger LOGGER = LogManager.getLogger(Staff.class);

    @XmlElementWrapper
    @XmlElement(name = "lawyer")
    @JsonProperty("lawyers")
    private List<Lawyer> lawyers;

    public Staff(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public Staff() {

    }

    public void showAllLawyers(List<Lawyer> lawyers) {
        for (Lawyer lawyer : lawyers) {
            LOGGER.info(lawyer.getName() + " has rating " + lawyer.getRating() + "; ");
        }
    }

    public void allLawyersBirthdays(List<Lawyer> lawyers) {
        for (Lawyer lawyer : lawyers) {
            LOGGER.info(lawyer.getName() + " was born " + lawyer.getBirthday());
        }
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "lawyers=" + lawyers +
                '}';
    }
}
