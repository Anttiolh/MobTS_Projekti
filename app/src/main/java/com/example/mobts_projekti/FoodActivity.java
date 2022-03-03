package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobts_projekti.percistance.SavedUserData;
import com.example.mobts_projekti.percistance.Utils;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class FoodActivity extends AppCompatActivity {
    Water water;
    Food food;

    String today = Utils.now();
    List<Actions> fullList = (List<Actions>) SavedUserData.ReadObjectFromFile();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        food = new Food();
        water = new Water();
    }

    public void addFood(View view){
        food.add();
        TextView foodHit = findViewById(R.id.foodCountText);
        String foodNumber;
        foodNumber = (food.getValue());
        foodHit.setText(foodNumber + " annosta");
    }

    public void addWater(View view){
        water.add();
        TextView drinkHit = findViewById(R.id.drinkCountText);
        String drinkNumber;
        drinkNumber = (water.getValue());
        drinkHit.setText(drinkNumber + "ml");
    }
    public void subtractWater(View view){
        water.subtract();
        TextView drinkHit = findViewById(R.id.drinkCountText);
        String drinkNumber;
        drinkNumber = (water.getValue());
        drinkHit.setText(drinkNumber + "ml");
    }

    public void subtractFood(View view){
        food.subtract();
        TextView foodHit = findViewById(R.id.foodCountText);
        String foodNumber;
        foodNumber = (food.getValue());
        foodHit.setText(foodNumber + " annosta");
    }
}

