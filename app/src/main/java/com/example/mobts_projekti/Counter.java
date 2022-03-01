package com.example.mobts_projekti;

import android.content.Intent;

public class Counter {
    private int mealValue;
    private int drinkValue;
    private int exerciseValue;

    public Counter(){
    }

    public void addDrink(int amount){
    if (drinkValue+amount<=10000){
        drinkValue += amount;
    }
    }

    public void addMeal(){
        if (mealValue<=15) {
            mealValue++;
        }
    }

    public void resetDay(){
        mealValue = 0;
        drinkValue = 0;
        exerciseValue = 0;
    }

    public void addExercise(int time){
        exerciseValue += time;
    }

    public String getWaterValue(){ return Integer.toString(drinkValue);
    }

    public String getMealValue(){
        return Integer.toString(mealValue);
    }

    public String getExerciseValue(){
        return Integer.toString(exerciseValue);
    }
}


