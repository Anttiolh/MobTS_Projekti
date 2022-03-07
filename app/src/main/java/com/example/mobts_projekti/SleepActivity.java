package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.SensorEvent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.example.mobts_projekti.percistance.Utils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SleepActivity extends AppCompatActivity {
    private static final String TAG = "TESTI";
    private TimePicker timePicker;
    private int hour;
    private int min;
    private BarChart barChart;
    SleepHours save;
    private ArrayList<Double> valueList;
    private ArrayList<BarEntry> entries;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        timePicker = findViewById(R.id.timePicker);
        barChart = findViewById(R.id.barChart);
        valueList = new ArrayList<>();
        entries = new ArrayList<>();
        timePicker.setIs24HourView(true);
    }

    //Add sleep time
    public void setSleepTime(View view) {
        hour = timePicker.getCurrentHour();
        min = timePicker.getCurrentMinute();
        save = new SleepHours(hour, min);
        save.add();
        showBarChart();
    }

    //Display sleep data on bars
    private void showBarChart() {
        String title = "Uni";

        for (int i = 0; i < save.getSize(); i++) {
            valueList.add(save.getSleepTime(i));
            if (save.getSize() > 5) {
                save.clearOne();
            }
        }

        for (int i = 0; i < valueList.size(); i++) {
            BarEntry barEntry = new BarEntry(i, valueList.get(i).floatValue());
            if (entries.size() >= 5) {
                entries.remove(0);
            }
            entries.add(barEntry);

        }
        BarDataSet barDataSet = new BarDataSet(entries, title);
        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();
    }
}