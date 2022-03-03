package com.example.mobts_projekti;
import com.example.mobts_projekti.percistance.SavedUserData;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;


public class Food extends Actions {
    public Food() {
        counter = new Counter(16, 0, 1);
        type = SavedUserData.type.Food;
    }

    public Food(int value) {
        counter = new Counter(16, 0, 1);
        counter.setValue(value);
        type = SavedUserData.type.Food;
    }
}