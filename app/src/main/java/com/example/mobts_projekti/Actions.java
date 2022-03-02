package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import java.time.ZoneId;

public abstract class Actions extends AppCompatActivity {
    Counter counter = new Counter(16,0,1);

    public void add(){
        counter.add();
    }

    public void subtract(){
        counter.subtract();
    }

    public String getValue(){
       return counter.getValue();
    }
}
