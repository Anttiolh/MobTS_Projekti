package com.example.mobts_projekti;

import android.text.Editable;

import com.example.mobts_projekti.percistance.SavedUserData;

import java.util.ArrayList;

public class SaveExercise extends Actions{

    ArrayList<SaveExercise> exercises = new ArrayList<>();
    private String exerciseContents;
    private String exerciseStress;

    public SaveExercise(String exerciseContents, String exerciseStress) {
        this.exerciseContents = exerciseContents;
        this.exerciseStress = exerciseStress;
    }

    public void add(){
        SaveExercise newSave = new SaveExercise(this.exerciseContents, this.exerciseStress);
        exercises.add(newSave);
        type = SavedUserData.type.Exercises;
    }

    public String toString(){
        return this.exerciseContents + ", " + this.exerciseStress;
    }

    public int getSize(){
        return exercises.size();
    }
}
