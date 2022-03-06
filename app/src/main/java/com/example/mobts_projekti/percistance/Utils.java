package com.example.mobts_projekti.percistance;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.mobts_projekti.Actions;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class Utils {

    public static String now() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH);
    }
}