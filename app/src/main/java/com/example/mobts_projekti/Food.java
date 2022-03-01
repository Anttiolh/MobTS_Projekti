package com.example.mobts_projekti;

import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class Food extends AppCompatActivity implements Actions{
    Counter counter = new Counter(16, 0, 1);
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
