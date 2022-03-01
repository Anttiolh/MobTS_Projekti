package com.example.mobts_projekti;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.util.ArrayList;
import java.util.Calendar;

public class SleepActivity extends AppCompatActivity {
    private static final String TAG = "TESTI";
    private ArrayList<Integer> SleepHours = new ArrayList<>();
    private int hours;
    private int minutes;
    private int hour;
    private int minute;
    int status = 0;
    AlarmActivity alarm = new AlarmActivity();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void createAlarm(View v){
        TimePicker tp = findViewById(R.id.timePicker);
        Button button = findViewById(R.id.submit_button);
        tp.setIs24HourView(true);
        tp.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void setAlarm(View v){
        TimePicker tp = findViewById(R.id.timePicker);
        hour = tp.getHour();
        minute = tp.getMinute();
        Log.d(TAG, "Alarm is being made with these parameters: " + hour + minute);
        AlarmActivity x = new AlarmActivity(hour, minute);
        x.setAlarm();
    }

    public void Settings(View v){
        Log.d(TAG, "Settings was called!");
        alarm.setRingtone();
    }

    public void powerNap(View v){
        TimePicker tp = findViewById(R.id.timePicker);
        Button button = findViewById(R.id.submit_button);
        tp.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        Calendar calendar = Calendar.getInstance();
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        minute = minute + 20;
        if (minute > 60){
            minute = minute-60;
            hour = hour + 1;
        }
        if (hour > 23){
            hour = hour-24;
        }
        Log.d(TAG, "Power nap alarm is se to ring at: " + hour + minute);
        AlarmActivity x = new AlarmActivity(hour, minute);
        x.setAlarm();
    }

    private void movementDetector(SensorEvent event){
    }
}