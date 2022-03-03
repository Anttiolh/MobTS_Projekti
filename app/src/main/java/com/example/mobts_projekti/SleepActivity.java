package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorEvent;
import android.os.Bundle;
import android.view.View;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class SleepActivity extends AppCompatActivity {
    private static final String TAG = "TESTI";
    private ArrayList<Integer> SleepHours = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

    }

    private void movementDetector(SensorEvent event){
    }

    public void onToggleClicked(View view){
        if(((ToggleButton)view).isChecked()){


        } else {

        }
    }
}