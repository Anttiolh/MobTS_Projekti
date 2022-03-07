package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mobts_projekti.percistance.SavedUserData;
import com.example.mobts_projekti.percistance.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TESTI";
    private TextView date;
    private Date today;
    private String dayString;
    private SimpleDateFormat dateFormat;
    TextView foodToday;
    TextView drinkToday;
    TextView exerciseToday;
    TextView sleepToday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner menu = findViewById(R.id.dropDownMenu);

        date = findViewById(R.id.editTextDate);
        today = new Date();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dayString = today.toString();
        date.setText(dayString);
        foodToday = findViewById(R.id.foodToday);
        drinkToday = findViewById(R.id.drinkToday);
        sleepToday = findViewById(R.id.sleepToday);
        exerciseToday = findViewById(R.id.exerciseToday);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        menu.setAdapter(adapter);

        menu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                switch (pos) {
                    case 0:
                        break;
                    case 1:
                        Intent intent = new Intent(MainActivity.this, SleepActivity.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this, ExerciseActivity.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this, FoodActivity.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this, AchievementsActivity.class);
                        startActivity(intent);
                        break;
                }
            }

            public void onNothingSelected(AdapterView<?> parent) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        loadVariables();
        InitializeMapFromFile();
        updateFoodLabelText();
        updateWaterLabelText();
        initializeMapFromFileExercises();
        updateExerciseLabelText();
    }

    @Override
    public void onResume() {
        super.onResume();
        fullList = null;
        InitializeMapFromFile();
        updateFoodLabelText();
        updateWaterLabelText();
        historyExercises = null;
        initializeMapFromFileExercises();
        updateExerciseLabelText();
    }

    Map<String, Actions> fullList;

    private void InitializeMapFromFile() {
        if (fullList == null) {
            fullList = (Map<String, Actions>) SavedUserData.ReadObjectFromFile(this, SavedUserData.type.Food);
            if (fullList == null) {
                fullList = new HashMap<>();
            }
        }
    }

    private void updateFoodLabelText() {
        String foodIdentifier = Utils.now() + "_" + SavedUserData.type.Food;
        String foodNumber;
        foodNumber = fullList.get(foodIdentifier) == null ? "0" : fullList.get(foodIdentifier).getValue();
        foodToday.setText("\t\t\t\t\t\tSyödyt annokset\t\t\t\t\t" + foodNumber + "\t\tannosta");
    }

    private void updateWaterLabelText() {
        String waterIdentifier = Utils.now() + "_" + SavedUserData.type.Water;
        String drinkNumber;
        drinkNumber = fullList.get(waterIdentifier) == null ? "0" : fullList.get(waterIdentifier).getValue();
        drinkToday.setText("\t\t\t\t\tJuodut juomat\t\t\t\t\t\t" + drinkNumber + "\t\ttml");

    }
    Map<String, List<SaveExercise>> historyExercises;

    private void initializeMapFromFileExercises() {
        if (historyExercises == null) {
            historyExercises = (Map<String, List<SaveExercise>>) SavedUserData.ReadObjectFromFile(this, SavedUserData.type.Exercises);
            if (historyExercises == null) {
                historyExercises = new HashMap<>();
            }
        }
    }


    private void updateExerciseLabelText() {
        String exerciseIdentifier = Utils.now() + "_" + SavedUserData.type.Exercises;
        List<SaveExercise> listExercise;
        listExercise = historyExercises.get(exerciseIdentifier) == null ? null : historyExercises.get(exerciseIdentifier);
        String exerciseLabel = "\t\t\tPäivän treeni\t\t\t\t\t\t\t";
        exerciseToday.setText((listExercise == null || listExercise.isEmpty()) ? exerciseLabel + "Ei tehty" : exerciseLabel + "Tehty");
    }
    public void loadVariables() {
    }
}