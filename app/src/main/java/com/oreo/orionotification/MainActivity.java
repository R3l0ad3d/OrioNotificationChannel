package com.oreo.orionotification;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Intent newIntent;
    AlarmManager manager;
    PendingIntent pendingIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newIntent=new Intent(this,NotificationReceiver.class);
        pendingIntent= PendingIntent.getBroadcast(this,200,newIntent,PendingIntent.FLAG_UPDATE_CURRENT);
        manager=(AlarmManager)getSystemService(Context.ALARM_SERVICE) ;
        manager.setRepeating(AlarmManager.RTC_WAKEUP,System.currentTimeMillis(),5000,pendingIntent);

    }
}
