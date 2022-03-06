package com.example.mobts_projekti;

import java.io.Serializable;

public class SaveExercise implements Serializable {

    private final String exerciseContents;
    private final String exerciseStress;

    public SaveExercise(String exerciseContents, String exerciseStress) {
        this.exerciseContents = exerciseContents;
        this.exerciseStress = exerciseStress;
    }

    public String toString() {
        return this.exerciseContents + ", " + this.exerciseStress;
    }

    public String getExerciseContents() {
        return exerciseContents;
    }

    public String getExerciseStress() {
        return exerciseStress;
    }
}
