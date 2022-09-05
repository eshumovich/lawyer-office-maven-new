package com.solvd.lawyers;

import com.solvd.lawyers.characteristic.Lawyer;
import com.solvd.lawyers.characteristic.Staff;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public final class LawyerOfficeUtils {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOfficeUtils.class);

    public static void getBetterLawyer(LawyerOffice lawyerOffice) {
        Staff staff = lawyerOffice.getStaff();
        List<Lawyer> lawyers  = staff.getLawyers();
        for (Lawyer lawyer: lawyers) {
            if (lawyer.getRating() > 9) {
                LOGGER.info("Name" + " with rating " + lawyer.getRating() + " is chosen");
            }
        }
    }

    public static void showEducation(Lawyer... lawyers) {
        for (Lawyer lawyer : lawyers) {
            lawyer.enterUniversity();
        }
    }
}
