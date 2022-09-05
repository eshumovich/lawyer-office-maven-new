package com.solvd.lawyers.characteristic;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class CourtHouse {

    private static final Logger LOGGER = LogManager.getLogger(CourtHouse.class);

    private DayOfWeek dayOfWeek;

    public enum DayOfWeek {

        MONDAY("Monday"),
        TUESDAY("Tuesday"),
        WEDNESDAY("Wednesday"),
        THURSDAY("Thursday"),
        FRIDAY("Friday"),
        SATURDAY("Saturday"),
        SUNDAY("Sunday");

        private final String title;

        DayOfWeek(String title){
            this.title = title;
        }

        public String getTitle() {
            return title;
        }
    }

    public CourtHouse() {
    }

    public void bookCourtHouse(LocalDateTime dateTime) {
        LOGGER.info("CourtHouse is booked on: " + dateTime);
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
