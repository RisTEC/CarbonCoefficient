package com.example.mainactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class finalActivity extends AppCompatActivity {
    private TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent g = getIntent();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        String[] finalTotal = g.getStringArrayExtra("SendOverValue");
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText(finalTotal[0]);

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