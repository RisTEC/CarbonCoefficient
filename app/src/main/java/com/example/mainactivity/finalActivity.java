package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class finalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
    }
    public void restart(View v){
        Intent b = new Intent(finalActivity.this,MainActivity.class);
        startActivity(b);
    }
    public void knowmore(View v){
        Intent l = new Intent(finalActivity.this, processActivity.class);
        startActivity(l);
    }
}