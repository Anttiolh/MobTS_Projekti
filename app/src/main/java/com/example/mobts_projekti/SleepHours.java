package com.example.mobts_projekti;

import java.io.Serializable;

public class SleepHours implements Serializable {
    private final int hour;
    private final int min;


    public SleepHours(int newHour, int newMin) {
        this.hour = newHour;
        this.min = newMin;
    }

    public Double getSleepTime() {
        int thisHour = hour;
        int thisMin = min;
        double timeSlept = Math.ceil(thisMin / 60.0) + thisHour;
        return timeSlept;
    }

    public Double getSleepTimeDisplay() {
        int thisHour = hour;
        int thisMin = min;
        double timeSlept = (thisMin / 60.0) + thisHour;
        return timeSlept;
    }


}
