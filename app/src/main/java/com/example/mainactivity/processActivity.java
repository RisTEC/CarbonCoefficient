package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class processActivity extends AppCompatActivity {
    private TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        textView3 = (TextView) findViewById(R.id.textView3);
        setContentView(R.layout.activity_process);
        Intent i = getIntent();
        String answer = i.getStringExtra("answer");
        textView3.setText(String.valueOf(answer));
    }
}