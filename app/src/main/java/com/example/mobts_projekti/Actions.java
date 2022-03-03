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
    Calendar calendar;

    public void add() {
        counter.add();
        calendar = Calendar.getInstance();
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void subtract() {
        counter.subtract();
        calendar = Calendar.getInstance();
    }

    public String getValue() {
        return counter.getValue();
    }

    public int getRawValue() {
        return counter.getValueRaw();
    }

    @Override
    public String toString() {
        return "Actions{" +
                "counter=" + counter.getValueRaw() +
                ", type=" + type +
                ", calendar=" + Utils.parseCalendarToString(calendar) +
                '}';
    }
}