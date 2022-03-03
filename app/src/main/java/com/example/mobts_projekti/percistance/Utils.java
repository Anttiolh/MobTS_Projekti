package com.example.mobts_projekti.percistance;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobts_projekti.Actions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    public static String parseCalendarToString(Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(calendar.getTime());
    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static List<Actions> getFilteredList(List<Actions> fooList, SavedUserData.type type, String calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return fooList.stream().filter(f -> (type == f.type && sdf.format(f.getCalendar().getTime()).equals(calendar))).collect(Collectors.toList());
    }

    public static List<Actions> recordsSavedForDate(List<Actions> fooList, String calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return fooList.stream().filter(f -> (sdf.format(f.getCalendar().getTime()).equals(calendar))).collect(Collectors.toList());
    }
}