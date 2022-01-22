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
                String engine_type = etn3.getText().toString();
                int age = Integer.parseInt(etn2.getText().toString());
                int car_km = Integer.parseInt(etn4.getText().toString());
                int bus_km = Integer.parseInt(etn5.getText().toString());
                int flights_km = Integer.parseInt(etn6.getText().toString());
                int meat_serving = Integer.parseInt(etn7.getText().toString());
                int delivery = Integer.parseInt(etn8.getText().toString());
                int geyser_min = Integer.parseInt(etn9.getText().toString());
                int load_machine = Integer.parseInt(etn10.getText().toString());
                int fan_hour = Integer.parseInt(etn11.getText().toString());
                int light_hour = Integer.parseInt(etn12.getText().toString());
                int plastic_item = Integer.parseInt(etn13.getText().toString());
                final int diesel_emission=130;
                final int petrol_emission=120;
                final int electric_emission=60;
                final int delivery_emission=415;
                final int meat_constant=1820;
                final int milk_constant=800;
                final int machine_emission=700;
                final int bus_emission=100;
                final int flights_emission=146;
                final int geyser_constant=12;
                final int fan_electricity_em=50;
                final int light_electricity_em=7;
                final int emission_per_item=450;
                double electricity,lifestyle;
                double transport;
                String name = etn1.getText().toString();

                        electricity=(geyser_min*30*geyser_constant)+(fan_hour*30*fan_electricity_em)+(light_hour*30*light_electricity_em)+(load_machine*4*machine_emission);
                       electricity/=Math.pow(10,6);

                       lifestyle=(plastic_item*4*emission_per_item)+(meat_serving*meat_constant*4)+(delivery*4*delivery_emission);
                       lifestyle/=Math.pow(10,6);

                        transport=(bus_km*4*bus_emission)+((double)flights_km/12 * flights_emission);
                        if(engine_type.equalsIgnoreCase("diesel")){
                            transport+=(car_km*30*diesel_emission);
                        }
                        else if(engine_type.equalsIgnoreCase("petrol")){
                            transport+=(car_km*30*petrol_emission);
                        }
                       else{
                            transport+=(car_km*30*electric_emission);
                        }
                        transport/=Math.pow(10,6);

                        double total=transport+lifestyle+electricity;
                        double average=0.30;
                        if(plastic_item>3){

                        }
                        if(car_km*7>bus_km){

                        }
                        if(light_hour>5 || fan_hour>10){

                        }
                        if(car_km*7 + bus_km>=100){

                       }
                        if(meat_serving>4){

                        }
                        double pct;
                        if(total>average){
                            pct=((total-average)/average)*100;

                        }
                        else if(total<average){
                           pct=((average-total)/total)*100;

                        }

            }
        });
    }
}