package com.example.mobts_projekti.percistance;

import com.example.mobts_projekti.SaveExercise;
import com.example.mobts_projekti.SleepHours;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class Utils {

    public static String now() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.YEAR) + "-" + cal.get(Calendar.MONTH) + "-" + cal.get(Calendar.DAY_OF_MONTH);
    }

    public static String parseCalendarToString(Calendar cal) {
        return (new SimpleDateFormat("dd-MM-yyyy")).format(cal.getTime());
    }

    public static String formatExerciseHistory(List<SaveExercise> listExercise) {
        if (listExercise == null) {
            return "Ei suorituksia!";
        }
        String labelTemplate = "Harjoitus: {0}, Rasitus: {1} \n";
        String result = "";
        for (SaveExercise exercise : listExercise) {
            result += labelTemplate.replace("{0}", exercise.getExerciseContents()).replace("{1}", exercise.getExerciseStress());
        }
        return result;
    }

    public static Calendar getCalendar(int day, int month, int year) {
        Calendar date = Calendar.getInstance();
        date.set(Calendar.YEAR, year);
        date.set(Calendar.MONTH, month + 1);
        date.set(Calendar.DAY_OF_MONTH, day);
        return date;
    }

    public static Double calculateTotalHoursSleepDay(List<SleepHours> list) {
        double total = 0.0;
        if(list != null && list.size() > 0) {
            for (SleepHours sleepHours: list) {
                total += sleepHours.getSleepTimeDisplay();
            }
        }
        return total;
    }
}
