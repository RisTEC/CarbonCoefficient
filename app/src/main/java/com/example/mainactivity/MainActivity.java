package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void launchInput(View v){
        //launch a new activity that gets input
        Intent i = new Intent(this, inputActivity.class);
        startActivity(i);
    }
    public void launchknowprocess(View v){
        //launch a new activity that gets input
        Intent i = new Intent(this, processActivity.class);
        startActivity(i);
    }
}