package com.example.mainactivity;

import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.mainactivity.databinding.ActivityInputBinding;

public class inputActivity extends AppCompatActivity {
    private EditText etn1;
    private EditText etn2;
    private EditText etn3;
    private EditText etn4;
    private EditText etn5;
    private EditText etn6;
    private EditText etn7;
    private EditText etn8;
    private EditText etn9;
    private EditText etn10;
    private EditText etn11;
    private EditText etn12;
    private EditText etn13;


private ActivityInputBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     binding = ActivityInputBinding.inflate(getLayoutInflater());
     setContentView(binding.getRoot());
        etn1 = (EditText) findViewById(R.id.etn1);
        etn2 = (EditText) findViewById(R.id.etn2);
        etn3 = (EditText) findViewById(R.id.etn3);
        etn4 = (EditText) findViewById(R.id.etn4);
        etn5 = (EditText) findViewById(R.id.etn5);
        etn6 = (EditText) findViewById(R.id.etn6);
        etn7 = (EditText) findViewById(R.id.etn7);
        etn8 = (EditText) findViewById(R.id.etn8);
        etn9 = (EditText) findViewById(R.id.etn9);
        etn10 = (EditText) findViewById(R.id.etn10);
        etn11 = (EditText) findViewById(R.id.etn11);
        etn12 = (EditText) findViewById(R.id.etn12);

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "press to calculate", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
            public void avgcarb (View v){
                int age = Integer.parseInt(etn2.getText().toString());
                int kmc = Integer.parseInt(etn4.getText().toString());
                int kmb = Integer.parseInt(etn5.getText().toString());
                int kmy = Integer.parseInt(etn6.getText().toString());
                int sm = Integer.parseInt(etn7.getText().toString());
                int del = Integer.parseInt(etn8.getText().toString());
                int gey = Integer.parseInt(etn9.getText().toString());
                int wm = Integer.parseInt(etn10.getText().toString());
                int fan = Integer.parseInt(etn11.getText().toString());
                int lights = Integer.parseInt(etn12.getText().toString());
                int disp = Integer.parseInt(etn13.getText().toString());

            }
        });
    }
}