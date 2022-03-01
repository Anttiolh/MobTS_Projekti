package com.example.mobts_projekti;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Water extends AppCompatActivity implements Actions {
    public Water(){

    }
    public Counter counter = new Counter(10000, 0, 100);

    @Override
    public void add() {
        counter.add();
    }

    @Override
    public void subtract() {
        counter.subtract();
    }

    @Override
    public String getValue() {
        return counter.getValue();
    }
}
