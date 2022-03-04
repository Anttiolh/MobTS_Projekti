package com.example.mobts_projekti;

import android.Manifest;
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
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.github.mikephil.charting.charts.BarChart;

public class ExerciseActivity extends AppCompatActivity implements SensorEventListener {
    private TextView tvStepCounter;
    private SensorManager sensorManager;
    private Sensor stepCounter;
    private boolean isCounterPresent;
    private int stepCount = 0;
    private boolean status;
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

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);
        chart = findViewById(R.id.BarChart);
        rg = findViewById(R.id.RadioGroup);
        exerciseInfo = findViewById(R.id.textView2);
        chooseFromMenu = findViewById(R.id.textView4);
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
        if (!status) {
            editText.setText("");
            rg.clearCheck();
            chart.setVisibility(View.INVISIBLE);
            rg.setVisibility(View.VISIBLE);
            exerciseInfo.setVisibility(View.VISIBLE);
            chooseFromMenu.setVisibility(View.VISIBLE);
            chooseStress.setVisibility(View.VISIBLE);
            editText.setVisibility(View.VISIBLE);
            spinner.setVisibility(View.VISIBLE);
            button.setVisibility(View.VISIBLE);
            status = true;
        } else if (status){
            chart.setVisibility(View.VISIBLE);
            rg.setVisibility(View.INVISIBLE);
            exerciseInfo.setVisibility(View.INVISIBLE);
            chooseFromMenu.setVisibility(View.INVISIBLE);
            chooseStress.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.INVISIBLE);
            button.setVisibility(View.INVISIBLE);
            status = false;
        }
    }

    public void saveExercise(View v){
        exerciseContents = editText.getText().toString();
        if (rg.getCheckedRadioButtonId() == R.id.radioButton_light){
            exerciseStress = "Kevyt";
        } else if (rg.getCheckedRadioButtonId() == R.id.radioButton_medium){
            exerciseStress = "Keskiraskas";
        } else if (rg.getCheckedRadioButtonId() == R.id.radioButton_heavy) {
            exerciseStress = "Raskas";
        } else {
            exerciseStress = "";
        }
        if (exerciseContents.matches("")){
            Toast.makeText(this, "Kaikki kentät eivät ole täytetty!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (exerciseStress.matches("")){
            Toast.makeText(this, "Kaikki kentät eivät ole täytetty!", Toast.LENGTH_SHORT).show();
            return;
        }
        SaveExercise save = new SaveExercise(exerciseContents, exerciseStress);
        save.add();
        chart.setVisibility(View.VISIBLE);
        rg.setVisibility(View.INVISIBLE);
        exerciseInfo.setVisibility(View.INVISIBLE);
        chooseFromMenu.setVisibility(View.INVISIBLE);
        chooseStress.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.INVISIBLE);
        button.setVisibility(View.INVISIBLE);
        status = false;
    }
}