package com.example.mobts_projekti;
import com.example.mobts_projekti.percistance.SavedUserData;
import com.example.mobts_projekti.percistance.Utils;

import java.util.Calendar;
import java.io.Serializable;

import android.widget.CalendarView;
import androidx.appcompat.app.AppCompatActivity;
import java.time.ZoneId;

public abstract class Actions implements Serializable {
    Counter counter = new Counter(16, 0, 1);
    public SavedUserData.type type;

    public void add() {
        counter.add();
    }

    public void subtract() {
        counter.subtract();
    }

    public String getValue() {
        return counter.getValue();
    }

    @Override
    public String toString() {
        return "Actions{" +
                "counter=" + counter.getValueRaw() +
                ", type=" + type +
                '}';
    }
}