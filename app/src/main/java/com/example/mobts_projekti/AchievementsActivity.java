package com.example.mobts_projekti;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobts_projekti.percistance.SavedUserData;
import com.example.mobts_projekti.percistance.Utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AchievementsActivity extends AppCompatActivity {
    DatePickerDialog picker;
    EditText eText;
    TextView tvw;
    Map<String, List<SaveExercise>> historyExercises;
    String today = Utils.now();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_achievements);
        tvw = findViewById(R.id.textView1);
        eText = findViewById(R.id.editText1);
        eText.setInputType(InputType.TYPE_NULL);
        eText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(AchievementsActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                updateExerciseText(year + "-" + monthOfYear + "-" + dayOfMonth);
                                eText.setText(Utils.parseCalendarToString(Utils.getCalendar(dayOfMonth, monthOfYear, year)));
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        initializeMapFromFile();
        updateExerciseText(today);
    }

    private void initializeMapFromFile() {
        if (historyExercises == null) {
            historyExercises = (Map<String, List<SaveExercise>>) SavedUserData.ReadObjectFromFile(this, SavedUserData.type.Exercises);
            if (historyExercises == null) {
                historyExercises = new HashMap<>();
            }
        }
    }

    private void updateExerciseText(String date) {
        String exerciseIdentifier = date + "_" + SavedUserData.type.Exercises;
        List<SaveExercise> listExercise;
        listExercise = historyExercises.get(exerciseIdentifier) == null ? null : historyExercises.get(exerciseIdentifier);
        tvw.setText(Utils.formatExerciseHistory(listExercise));
    }

    @Override
    public void onResume() {
        super.onResume();
        historyExercises = null;
        initializeMapFromFile();
        updateExerciseText(today);
        eText.setText(Utils.parseCalendarToString(Calendar.getInstance()));
    }
}