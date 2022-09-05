package com.solvd.lawyers.characteristic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Staff {

    private static final Logger LOGGER = LogManager.getLogger(Staff.class);

    private List<Lawyer> lawyers;

    public Staff(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }

    public void showAllLawyers(List<Lawyer> lawyers) {
        for (Lawyer lawyer : lawyers) {
            LOGGER.info(lawyer.getName() + " has rating " + lawyer.getRating() + "; ");
        }
    }

    public void allLawyersBirthdays(List<Lawyer> lawyers) {
        for (Lawyer lawyer : lawyers) {
            LOGGER.info(lawyer.getName() + " was born " + lawyer.getBirth());
        }
    }

    public List<Lawyer> getLawyers() {
        return lawyers;
    }

    public void setLawyers(List<Lawyer> lawyers) {
        this.lawyers = lawyers;
    }
}
