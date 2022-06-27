package com.example.optitrackclicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.format.Time;
import android.view.View;

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
        today.setToNow();
        database.getReference("ButtonInput").child("" + today.toMillis(true)).setValue("pressed"+count);
        count++;
    }
}