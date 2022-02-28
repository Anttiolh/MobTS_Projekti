package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class SleepActivity extends AppCompatActivity {
    private ArrayList<Integer> SleepHours = new ArrayList<>();
    AlarmActivity alarm= new AlarmActivity();
    private int hours;
    private int minutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
    }

    public void onClick(View view){
    }

    public void Settings(){
        alarm.setRingtone();
    }

    public void powerNap(){
        alarm.setPowerNap();
    }

    private void getTime(){
        TextView text = findViewById(R.id.textView4);
        hours = new Date().getHours();
        minutes = new Date().getMinutes();
        String a=String.valueOf(hours);
        String b=String.valueOf(minutes);
        text.setText(a + ":" + b);
    }
    private void movementDetector(SensorEvent event){
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            float diff = (float) Math.sqrt(x * x + y * y + z * z);
            if (diff > 0.5){
                getTime();
                SleepHours.add(hours + minutes);
            }
            if (diff < 0.5){
                getTime();
                SleepHours.add(hours + minutes);
            }
        }
    }
}