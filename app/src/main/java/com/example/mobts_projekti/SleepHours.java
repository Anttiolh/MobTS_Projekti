package com.example.mobts_projekti;

import java.util.ArrayList;

public class SleepHours {
    private int hour;
    private int min;
    private ArrayList<SleepHours> sleepList = new ArrayList<>();

    public SleepHours(int newHour, int newMin){
        this.hour = newHour;
        this.min = newMin;
    }

    public void add(){
        SleepHours newSleep = new SleepHours(this.hour, this.min);
        sleepList.add(newSleep);
    }

    public String getHours(){
        return sleepList.toString();
    }

    public double getSleepTime(int index){
        int thisHour = sleepList.get(index).hour;
        int thisMin = sleepList.get(index).min;
        double timeSlept = thisMin / 60 + thisHour;

        return timeSlept;
    }

    public int getSize(){
        return sleepList.size();
    }

    public void clearOne(){
        sleepList.remove(0);
    }

}
