package com.example.optitrackclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {


    FirebaseDatabase database = FirebaseDatabase.getInstance();
    public static int count=0;
    //DatabaseReference myRef = database.getReference("message");

    Time today = new Time(Time.getCurrentTimezone());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database.getReference().child("ButtonInput").removeValue();
    }

    public void onClick(View view)
    {
//        today.setToNow();
//        database.getReference("ButtonInput").child("" + today.toMillis(true)).setValue("pressed"+count);
//        count++;
    }







    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        int action = event.getAction();
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:
                if (action == KeyEvent.ACTION_UP) {
                    if (event.getEventTime() - event.getDownTime() > ViewConfiguration.getLongPressTimeout()) {
                        //TODO long click action
                        database.getReference("ButtonInput").child("" + System.currentTimeMillis()).setValue("pressed"+count);
                        count++;
                    } else {
                        //TODO click action
                        database.getReference("ButtonInput").child("" + System.currentTimeMillis()).setValue("pressed"+count);
                        count++;
                    }
                }
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                if (action == KeyEvent.ACTION_UP) {
                    if (event.getEventTime() - event.getDownTime() > ViewConfiguration.getLongPressTimeout()) {
                        //TODO long click action
                        database.getReference("ButtonInput").child("" + System.currentTimeMillis()).setValue("pressed"+count);
                        count++;
                    } else {
                        //TODO click action

                        database.getReference("ButtonInput").child("" + System.currentTimeMillis()).setValue("pressed"+count);
                        count++;
                    }
                }
                return true;
            default:
                return super.dispatchKeyEvent(event);
        }
    }





}