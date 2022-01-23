package com.example.carboncoefficent;

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
        String total = finalTotal[0].substring(0,4);
        textView.setText(total+ " Tonnes");
        TextView textView9 = (TextView) findViewById(R.id.textView5);
        textView9.setText(finalTotal[1]);
        TextView textView1 = (TextView) findViewById(R.id.textView6);
        textView1.setText(finalTotal[2]);
        TextView textView2 = (TextView) findViewById(R.id.textView7);
        textView2.setText(finalTotal[3]);
        TextView textView3 = (TextView) findViewById(R.id.textView8);
        textView3.setText(finalTotal[4]);
        TextView textView4 = (TextView) findViewById(R.id.textView9);
        textView4.setText(finalTotal[5]);
        TextView textView5 = (TextView) findViewById(R.id.textView10);
        textView5.setText(finalTotal[6]);
        TextView textView6 = (TextView) findViewById(R.id.textView11);
        textView6.setText(finalTotal[7]);
        TextView textView7 = (TextView) findViewById(R.id.textView12);
        textView7.setText(finalTotal[8]);
        TextView textView8 = (TextView) findViewById(R.id.textView13);
        textView8.setText(finalTotal[9]);

    }

    public void restart(View v){
        Intent b = new Intent(finalActivity.this,MainActivity.class);
        startActivity(b);

    }
}