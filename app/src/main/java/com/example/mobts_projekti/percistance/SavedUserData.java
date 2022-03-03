package com.example.mobts_projekti.percistance;

import android.renderscript.Long4;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SavedUserData {

    private static String fileToSave = "C:\\opt\\Counter\\counter_";

    public enum type {
        Food,
        Water,
        Steps,
        Sleep
    }

    //saving files
    public static void WriteObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream(fileToSave);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Object ReadObjectFromFile(){
        String currentDate = Utils.now();
        try {
            FileInputStream fileIn = new FileInputStream(fileToSave);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}


