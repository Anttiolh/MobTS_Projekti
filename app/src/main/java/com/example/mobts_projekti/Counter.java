package com.example.mobts_projekti;

import android.content.Intent;

public class Counter {

    private int value = 0;
    private int max;
    private int min;
    private int step;

    public Counter(int newMax, int newMin, int newStep){
        this.max = newMax;
        this.min = newMin;
        this.step = newStep;
    }

    public void add(){
        if (value<max) {
            value = value + step;
        }
    }

    public void subtract(){
        if (value > min){
            value = value - step;
        }
    }

    public void reset(){
        value = 0;
    }

    public String getValue(){
        return Integer.toString(value);
    }

}


