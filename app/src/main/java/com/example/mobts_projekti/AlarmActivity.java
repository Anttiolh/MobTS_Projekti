package com.example.mobts_projekti;

import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.provider.AlarmClock;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;
import java.util.Timer;


public class AlarmActivity extends AppCompatActivity {

    private static final String TAG = "TESTI";
    private int hour;
    private int minute;
    private int currentHour;
    private int currentMinute;
    private boolean status = false;

    public AlarmActivity(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public AlarmActivity(){
        this.hour = 0;
        this.minute = 0;
    }
    public void setAlarm() {
        Log.d(TAG, "AlarmActivity sets an alarm with these parameters: " + this.hour + this.minute);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Calendar calendar = Calendar.getInstance();
                    currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                    currentMinute = calendar.get(Calendar.MINUTE);
                    if (currentHour == hour && currentMinute == minute) {
                        Log.d(TAG, "PERKELE!");
                        status = true;
                    }
                    Log.d(TAG, "Runned!");
                }
            }, 1000);
        }

    public void removeAlarm(){

    }

    public void playAlarm(){

    }

    public void setRingtone(){
        Log.d(TAG, "setRingtone called!");
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        startActivity(intent);
    }

    public void playRingtone(){

    }
}
