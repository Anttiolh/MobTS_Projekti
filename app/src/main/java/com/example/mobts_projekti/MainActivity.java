package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "TESTI";
    private TextView date;
    private Date today;
    private String dayString;
    private SimpleDateFormat dateFormat;
    private Calendar calendar;
    TextView foodYesterday;
    TextView drinkYesterday;
    TextView sleepYesterday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Spinner menu = findViewById(R.id.dropDownMenu);

        date = findViewById(R.id.editTextDate);
        today = new Date();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dayString =  today.toString();
        date.setText(dayString);
        foodYesterday = findViewById(R.id.foodToday);
        drinkYesterday = findViewById(R.id.drinkToday);
        sleepYesterday = findViewById(R.id.sleepToday);
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
}

public void loadVariables(){
    }
}