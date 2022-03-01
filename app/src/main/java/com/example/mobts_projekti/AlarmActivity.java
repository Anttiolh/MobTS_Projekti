package com.example.mobts_projekti;

import android.content.Intent;
import android.database.Cursor;
import android.media.RingtoneManager;
import android.net.Uri;
import android.provider.AlarmClock;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;


public class AlarmActivity extends AppCompatActivity {

    private static final String TAG = "TESTI";
    private int hour;
    private int minute;

    public AlarmActivity(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    public AlarmActivity(){
        this.hour = 0;
        this.minute = 0;
    }
    public void setAlarm(){
    Log.d(TAG, "AlarmActivity sets an alarm with these parameters: " + this.hour + this.minute);
    Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
    intent.putExtra(AlarmClock.EXTRA_HOUR, this.hour);
    intent.putExtra(AlarmClock.EXTRA_MINUTES,this.minute);
    startActivity(intent);
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
