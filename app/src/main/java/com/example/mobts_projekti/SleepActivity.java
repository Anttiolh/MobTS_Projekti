package com.example.mobts_projekti;

import android.os.Bundle;
import android.view.View;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobts_projekti.percistance.SavedUserData;
import com.example.mobts_projekti.percistance.Utils;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SleepActivity extends AppCompatActivity {
    private static final String TAG = "TESTI";
    Map<String, List<SleepHours>> fullList;
    String today = Utils.now();
    private TimePicker timePicker;
    private int hour;
    private int min;
    private BarChart barChart;
    private List<SleepHours> sleepList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);
        timePicker = findViewById(R.id.timePicker);
        barChart = findViewById(R.id.barChart);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(new Integer(0));
        timePicker.setCurrentMinute(new Integer(0));
        InitializeMapFromFile();
        refreshCurrentRecord();
        showBarChart();
    }

    //Add sleep time
    public void setSleepTime(View view) {
        String sleepIdentifier = today + "_" + SavedUserData.type.Sleep;
        hour = timePicker.getCurrentHour();
        min = timePicker.getCurrentMinute();
        refreshCurrentRecord();
        sleepList.add(new SleepHours(hour, min));
        fullList.put(sleepIdentifier, sleepList);
        SavedUserData.WriteObjectToFile(this, fullList, SavedUserData.type.Sleep);
        showBarChart();
    }

    private void refreshCurrentRecord() {
        String sleepIdentifier = today + "_" + SavedUserData.type.Sleep;
        sleepList = fullList.get(sleepIdentifier) != null ? (List<SleepHours>) fullList.get(sleepIdentifier) : new ArrayList<>();
    }


    //Display sleep data on bars
    private void showBarChart() {
        String title = "Uni";
        ArrayList<BarEntry> entries = new ArrayList<>();
        int counter = 4;
        if (sleepList != null && sleepList.size() > 0)
            for (int i = sleepList.size() - 1; i >= 0; i--) {
                SleepHours sleepHour = sleepList.get(i);
                if (sleepHour != null && counter >= 0) {
                    entries.add(new BarEntry(counter, sleepHour.getSleepTime().floatValue()));
                    counter--;
                    // if size of records is bigger than 5 only display 5
                }
            }
        BarDataSet barDataSet = new BarDataSet(entries, title);
        BarData data = new BarData(barDataSet);
        barChart.setData(data);
        barChart.invalidate();
    }

    private void InitializeMapFromFile() {
        if (fullList == null) {
            fullList = (Map<String, List<SleepHours>>) SavedUserData.ReadObjectFromFile(this, SavedUserData.type.Sleep);
            if (fullList == null) {
                fullList = new HashMap<>();
            }
        }
    }
}