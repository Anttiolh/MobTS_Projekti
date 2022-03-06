package com.example.mobts_projekti;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mobts_projekti.percistance.SavedUserData;
import com.example.mobts_projekti.percistance.Utils;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;


public class FoodActivity extends AppCompatActivity {
    CalendarView simpleCalendarView;
    // display the selected date by using a toast
    String selectedDate = "";
    Food selectedFood;
    Water selectedDrink;

    String today = Utils.now();
    Map<String,Actions> fullList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView); // get the reference of CalendarView
        simpleCalendarView.setFocusedMonthDateColor(Color.RED); // set the red color for the dates of  focused month
        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE); // set the yellow color for the dates of an unfocused month
        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED); // red color for the selected week's background
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN); // green color for the week separator line
        // perform setOnDateChangeListener event on CalendarView
        simpleCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                selectDate(year + "-" + month + "-" + dayOfMonth);
            }
        });
        selectDate(today);
        updateFoodLabelText();
        updateWaterLabelText();
    }

    public void selectDate(String date) {
        InitializeMapFromFile();
        // display the selected date by using a toast
        selectedDate = date;
        // Food
        TextView foodHit = findViewById(R.id.foodCountText);
        String foodIdentifier = selectedDate + "_" + SavedUserData.type.Food;
        selectedFood = fullList.get(foodIdentifier) != null ? (Food)fullList.get(foodIdentifier) : null;
        String foodDisplay = selectedFood == null ? "0" : selectedFood.getValue() ;
        foodHit.setText(foodDisplay);
        // Drink
        TextView drinkHit = findViewById(R.id.drinkCountText);
        String drinkIdentifier = selectedDate + "_" + SavedUserData.type.Water;
        selectedDrink = fullList.get(drinkIdentifier) != null ? (Water)fullList.get(drinkIdentifier) : null;
        String drinkDisplay = selectedDrink == null ? "0" : selectedDrink.getValue() ;
        drinkHit.setText(drinkDisplay);
    }

    private void InitializeMapFromFile(){
        if(fullList == null) {
            fullList = (Map<String,Actions>) SavedUserData.ReadObjectFromFile(this, SavedUserData.type.Food);
            if (fullList == null) {
                fullList = new HashMap<>();
            }
        }
    }

    public void addFood(View view){
        selectedFood = selectedFood == null ? new Food() : selectedFood;
        selectedFood.add();
        updateFoodLabelText();
    }

    public void subtractFood(View view){
        selectedFood = selectedFood == null ? new Food() : selectedFood;
        selectedFood.subtract();
        updateFoodLabelText();
    }

    private void updateFoodLabelText() {
        String foodIdentifier = selectedDate + "_" + SavedUserData.type.Food;
        fullList.put(foodIdentifier, selectedFood);
        TextView foodHit = findViewById(R.id.foodCountText);
        String foodNumber;
        foodNumber = selectedFood == null ? "0" : (selectedFood.getValue());
        foodHit.setText(foodNumber);
        SavedUserData.WriteObjectToFile(this, fullList, SavedUserData.type.Food);
    }

    public void addWater(View view){
        selectedDrink = selectedDrink == null ? new Water() : selectedDrink;
        selectedDrink.add();
        updateWaterLabelText();
    }

    public void subtractWater(View view){
        selectedDrink = selectedDrink == null ? new Water() : selectedDrink;
        selectedDrink.subtract();
        updateWaterLabelText();
    }

    private void updateWaterLabelText() {
        String waterIdentifier = selectedDate + "_" + SavedUserData.type.Water;
        fullList.put(waterIdentifier, selectedDrink);
        TextView drinkHit = findViewById(R.id.drinkCountText);
        String drinkNumber;
        drinkNumber = selectedDrink == null ? "0" : (selectedDrink.getValue());
        drinkHit.setText(drinkNumber);
        SavedUserData.WriteObjectToFile(this, fullList, SavedUserData.type.Food);
    }
}

