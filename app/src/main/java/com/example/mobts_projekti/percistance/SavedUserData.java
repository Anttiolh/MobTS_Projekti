package com.example.mobts_projekti.percistance;

import android.content.Context;
import android.renderscript.Long4;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SavedUserData {

    private static String fileToSave = "HealthFile";

    public enum type {
        Food,
        Water,
        Steps,
        Sleep,
        Exercises
    }

    //saving files
    public static void WriteObjectToFile(Context context, Object serObj) {
        try {
            FileOutputStream fileOut = new FileOutputStream(new File(context.getFilesDir(), fileToSave));
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public static Object ReadObjectFromFile(Context context){
        try {
            FileInputStream fileIn = new FileInputStream(new File(context.getFilesDir(), fileToSave));
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


