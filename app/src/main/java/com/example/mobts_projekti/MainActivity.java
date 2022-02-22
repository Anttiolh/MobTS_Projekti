package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView date = findViewById(R.id.editTextDate);
        Date today = new Date();
        String dayString = today.toString();
        date.setText(dayString);

        final Spinner menu = findViewById(R.id.dropDownMenu);
        Button button = findViewById(R.id.button);

        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.menu, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        menu.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SleepActivity.class);
                startActivity(intent);
            }
        });
    }
}