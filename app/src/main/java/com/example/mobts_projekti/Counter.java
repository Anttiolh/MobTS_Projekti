package com.example.mobts_projekti;

import android.content.Intent;

import java.io.Serializable;

public class Counter implements Serializable {

    private int value = 0;
    private int max;
    private int min;
    private int step;

    public Counter(int newMax, int newMin, int newStep){
        this.max = newMax;
        this.min = newMin;
        this.step = newStep;
    }

    public void setValue(int value) {
        this.value = value;
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
    public String getValue()
    {
        return Integer.toString(value);
    }
    public int getValueRaw(){
        return value;
    }

}


