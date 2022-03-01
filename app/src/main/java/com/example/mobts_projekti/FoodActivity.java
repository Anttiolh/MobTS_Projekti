package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;


public class FoodActivity extends AppCompatActivity {
    Counter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        counter = new Counter();
    }

    public void addFood(View v) {
        TextView foodHit = findViewById(R.id.foodCountText);
        String foodNumber;
        counter.addMeal();
        foodNumber = (counter.getMealValue());
        foodHit.setText(foodNumber + " annosta");

    }

    public void addWater(View v) {
        TextView drinkHit = findViewById(R.id.drinkCountText);
        String drinkNumber;
        counter.addDrink(100);
        drinkNumber = (counter.getWaterValue());
        drinkHit.setText(drinkNumber + "ml");

    }
}

