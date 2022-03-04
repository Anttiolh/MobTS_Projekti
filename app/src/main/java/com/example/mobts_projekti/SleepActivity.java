package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.SensorEvent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

public class SleepActivity extends AppCompatActivity {
    private static final String TAG = "TESTI";
    private TimePicker timePicker;
    private int hour;
    private int min;
    private BarChart barChart;
    SleepHours save;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        timePicker = findViewById(R.id.timePicker);
        barChart = findViewById(R.id.barChart);

    }

    public void setSleepTime(View view){
        hour = timePicker.getCurrentHour();
        min = timePicker.getCurrentMinute();
        save = new SleepHours(hour, min);
        save.add();
        Log.d(TAG, "omg");
        showBarChart();
    }

    private void showBarChart(){
        ArrayList<Double>valueList = new ArrayList<>();
        ArrayList<BarEntry>entries = new ArrayList<>();
        String title = "Title";

        for (int i = 0; i<save.getSize();i++){
            valueList.add(save.getSleepTime(i) * 100.1);
        }

        for (int i = 0; i<valueList.size();i++){
            BarEntry barEntry = new BarEntry(i, valueList.get(i).floatValue());
            entries.add(barEntry);
        }

        BarDataSet barDataSet = new BarDataSet(entries, title);

        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();
    }
}