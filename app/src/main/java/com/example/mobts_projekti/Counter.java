package com.example.mobts_projekti;

import android.content.Intent;

public class Counter {
    private int mealValue;
    private int waterValue;
    private int exerciseValue;

    public Counter(){
        //this.current = this.start;
    }

    public void addWater(int amount){
        waterValue += amount;
    }

    public void addMeal(){
        mealValue++;
    }

    public void resetDay(){
        mealValue = 0;
        waterValue = 0;
        exerciseValue = 0;
    }

    public void addExercise(int time){
        exerciseValue += time;
    }

    public String getWaterValue(){
        return Integer.toString(waterValue);
    }

    public String getMealValue(){
        return Integer.toString(mealValue);
    }

    public String getExerciseValue(){
        return Integer.toString(exerciseValue);
    }
}


