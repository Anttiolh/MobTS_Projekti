package com.example.mobts_projekti;
import com.example.mobts_projekti.percistance.SavedUserData;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Water extends Actions {
    public Water() {
        counter = new Counter(10000, 0, 100);
        type = SavedUserData.type.Water;
    }

    public Water(int value) {
        counter = new Counter(10000, 0, 100);
        counter.setValue(value);
        type = SavedUserData.type.Water;
    }
}