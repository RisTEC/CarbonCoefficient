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
        etn13 = (EditText) findViewById(R.id.etn13);

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {


            public double calc()
            {
                String engine_type = etn3.getText().toString();
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

                lifestyle=(plastic_item*4*emission_per_item)+(meat_serving*meat_constant*4)+(delivery*5*delivery_emission);
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

                double total=transport+lifestyle+electricity;//send
                double average=0.30;
                String plastic_usage;//send
                if(plastic_item>3){
                    plastic_usage = "Try to reduce plastic consumption";
                }
                else
                    plastic_usage = "Plastic consumption is under control";
                String public_transport;//send
                if(car_km*7>bus_km){
                    public_transport ="Try to use public transport more";
                }
                else public_transport ="Car usage is adequate";
                String electric_consumption;//send
                if(light_hour>5 || fan_hour>10){
                    electric_consumption ="Try to reduce electricity consumption";
                }
                else electric_consumption ="Electricity consumption is proper";

                String cycling;//send
                if(car_km*7 + bus_km>=100){
                    cycling = "Try to use other means of transport like cycling";
                }
                else cycling = "Transport via vehicles is under control";
                String meat_usage;//send
                if(meat_serving>4){
                    meat_usage = "Try to eat less meat";

                }
                else meat_usage = "Meat consumption is reasonable";
                double pct;
                String emission;//send
                if(total>average){
                    pct=((total-average)/average)*100;
                    emission = "Your carbon footprint is " +pct+" % more than the average person";
                }
                else if(total<average){
                    pct=((average-total)/total)*100;
                    emission = "Your carbon footprint is " +pct+" % less than the average person";
                }
                double ePercent = (electricity/total)*100;//send
                double tPercent = (transport/total)*100;//send
                double lPercent = (lifestyle/total)*100;//send

                return total;
            }
            public void onClick(View view) {

                double returnedTotal = calc();
                Snackbar.make(view, "Average : "+ returnedTotal, Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

        });
    }
}