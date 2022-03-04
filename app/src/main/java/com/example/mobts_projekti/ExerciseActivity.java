package com.example.mobts_projekti;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;

import java.util.HashMap;

public class ExerciseActivity extends AppCompatActivity implements SensorEventListener {
    private TextView tvStepCounter;
    private SensorManager sensorManager;
    private Sensor stepCounter;
    private boolean isCounterPresent;
    private int stepCount = 0;
    BarChart chart;
    RadioGroup rg;
    TextView exerciseInfo;
    TextView chooseFromMenu;
    TextView chooseStress;
    EditText editText;
    Spinner spinner;
    Button button;
    String exerciseStress;
    String exerciseContents;
    HashMap<String, String> exercises = new HashMap<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        chart = findViewById(R.id.BarChart);
        rg = findViewById(R.id.RadioGroup);
        exerciseInfo = findViewById(R.id.textView2);
        chooseFromMenu = findViewById(R.id.textView3);
        chooseStress = findViewById(R.id.textView5);
        editText = findViewById(R.id.ExerciseName);
        spinner = findViewById(R.id.exerciseMenu);
        button = findViewById(R.id.save_button);
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.ACTIVITY_RECOGNITION)== PackageManager.PERMISSION_DENIED){
            requestPermissions(new String[]{Manifest.permission.ACTIVITY_RECOGNITION},0);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        tvStepCounter = findViewById(R.id.Steps);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!= null){
            stepCounter=sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
            isCounterPresent=true;
        }else{
            tvStepCounter.setText("Sensori ei ole aktiivinen");
            isCounterPresent=false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if(sensorEvent.sensor == stepCounter){
            stepCount = (int) sensorEvent.values[0];
            tvStepCounter.setText(String.valueOf(stepCount));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            sensorManager.registerListener(this, stepCounter,SensorManager.SENSOR_DELAY_NORMAL);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)!=null){
            sensorManager.unregisterListener(this,stepCounter);
        }
    }
    public void addExercise(View v){
        chart.setVisibility(View.INVISIBLE);
        rg.setVisibility(View.VISIBLE);
        exerciseInfo.setVisibility(View.VISIBLE);
        chooseFromMenu.setVisibility(View.VISIBLE);
        chooseStress.setVisibility(View.VISIBLE);
        editText.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.VISIBLE);
        button.setVisibility(View.VISIBLE);
        exerciseContents = (String) exerciseInfo.getText();
        if (rg.getCheckedRadioButtonId() == R.id.radioButton_light){
            exerciseStress = "Kevyt";
        } else if (rg.getCheckedRadioButtonId() == R.id.radioButton_medium){
            exerciseStress = "Keskiraskas";
        } else {
            exerciseStress = "Raskas";
        }

    }

    public void saveExercise(View v){
        exercises.put(exerciseContents, exerciseStress);
        chart.setVisibility(View.VISIBLE);
        rg.setVisibility(View.INVISIBLE);
        exerciseInfo.setVisibility(View.INVISIBLE);
        chooseFromMenu.setVisibility(View.INVISIBLE);
        chooseStress.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        TextView test = findViewById(R.id.test_text);
        test.setText(exercises.get(1));
    }
}