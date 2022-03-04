package com.example.mobts_projekti;

import java.util.ArrayList;

public class Day {
    ArrayList<Day> days = new ArrayList<>();
    private int day;
    private int sleep;
    private int food;
    private String exercise;

    public Day(int day, int sleep, int food, String exercise){
        this.day = day;
        this.sleep = sleep;
        this.food = food;
        this.exercise = exercise;
    }

}
