package com.example.mobts_projekti;

import com.example.mobts_projekti.percistance.SavedUserData;

public class Exercise extends Actions{

    public Exercise(){
        counter = new Counter(50, 0,1);
        type = SavedUserData.type.Exercises;
    }


}
