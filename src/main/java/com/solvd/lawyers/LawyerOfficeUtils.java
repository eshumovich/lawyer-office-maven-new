package com.solvd.lawyers;

import com.solvd.lawyers.characteristic.Lawyer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LawyerOfficeUtils {

    private static final Logger LOGGER = LogManager.getLogger(LawyerOfficeUtils.class);

    public static void showEducation(Lawyer... lawyers) {
        for (Lawyer lawyer : lawyers) {
            lawyer.enterUniversity();
        }
    }
}
