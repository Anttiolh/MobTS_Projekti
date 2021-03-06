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
    String selectedDate = "";
    Food selectedFood;
    Water selectedDrink;
    String today = Utils.now();
    Map<String,Actions> fullList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        simpleCalendarView = (CalendarView) findViewById(R.id.simpleCalendarView);
        simpleCalendarView.setFocusedMonthDateColor(Color.RED);
        simpleCalendarView.setUnfocusedMonthDateColor(Color.BLUE);
        simpleCalendarView.setSelectedWeekBackgroundColor(Color.RED);
        simpleCalendarView.setWeekSeparatorLineColor(Color.GREEN);
        // perform setOnDateChangeListener event on CalendarView
        simpleCalendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> selectDate(year + "-" + month + "-" + dayOfMonth));
        selectDate(today);
        updateFoodLabelText();
        updateWaterLabelText();
    }

    public void selectDate(String date) {
        InitializeMapFromFile();
        selectedDate = date;
        TextView foodHit = findViewById(R.id.foodCountText);
        String foodIdentifier = selectedDate + "_" + SavedUserData.type.Food;
        selectedFood = fullList.get(foodIdentifier) != null ? (Food)fullList.get(foodIdentifier) : null;
        String foodDisplay = selectedFood == null ? "0" : selectedFood.getValue() ;
        foodHit.setText(foodDisplay);
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

    /** This method is for Updating the text
     * Params: none
     * Return: Void
     */
    private void updateFoodLabelText() {
        String foodIdentifier = selectedDate + "_" + SavedUserData.type.Food;
        fullList.put(foodIdentifier, selectedFood);
        TextView foodHit = findViewById(R.id.foodCountText);
        String foodNumber;
        foodNumber = selectedFood == null ? "0" : (selectedFood.getValue());
        foodHit.setText(foodNumber + "\t\tannosta");
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
        drinkHit.setText(drinkNumber + "\t\tml");
        SavedUserData.WriteObjectToFile(this, fullList, SavedUserData.type.Food);
    }
}

