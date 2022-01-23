package com.example.carboncoefficent;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.carboncoefficent.databinding.ActivityInputBinding;

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

        Button btnCalc = (Button) findViewById(R.id.button5);
        btnCalc.setOnClickListener(new View.OnClickListener() {


            public String[] calc()
            {
                String name = etn1.getText().toString();
                String engine_type = etn3.getText().toString();
                int car_km = Integer.parseInt(etn4.getText().toString());

                int bus_km = Integer.parseInt(etn5.getText().toString());
                int flights_hours = Integer.parseInt(etn6.getText().toString());
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
                String Name = etn1.getText().toString();
                int flights_km = flights_hours*835;
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
                final double average=0.25;
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
                if(car_km*7 + bus_km*7>=100){
                    cycling = "Try to use other means of transport like cycling";
                }
                else cycling = "Transport via vehicles is under control";
                String meat_usage;//send
                if(meat_serving>4){
                    meat_usage = "Try to eat less meat";

                }
                else meat_usage = "Meat consumption is reasonable";
                double pct;
                String emission = null;//send
                if(total>average){
                    pct=((total-average)/average)*100;
                    String PCT = String.format("%.2f",pct);
                    emission = "Your carbon footprint is " +PCT+" % more than the average Indian";
                }
                else if(total<average){
                    pct=((average-total)/total)*100;
                    String PCT = String.format("%.2f",pct);
                    emission = "Your carbon footprint is " +PCT+" % less than the average Indian";
                }
                double ePercent = (electricity/total)*100;//send
                String epercent = String.format("%.2f",ePercent);
                double tPercent = (transport/total)*100;//send
                String tpercent = String.format("%.2f",tPercent);
                double lPercent = (lifestyle/total)*100;//send
                String lpercent = String.format("%.2f",lPercent);
                String[] sendOverValue = {
                        String.valueOf(total),
                        plastic_usage,
                        public_transport,
                        electric_consumption,
                        cycling,
                        meat_usage,
                        emission,
                        epercent,
                        tpercent,
                        lpercent,
                        name,
                };
                return sendOverValue;
            }
            public void onClick(View view) {
                String name = etn1.getText().toString();
                String engine_type = etn3.getText().toString();
                String car_km = etn4.getText().toString();
                String v5 = etn5.getText().toString();
                String v6 = etn6.getText().toString();
                String v7 = etn7.getText().toString();
                String v8 = etn8.getText().toString();
                String v9 = etn9.getText().toString();
                String v10 = etn10.getText().toString();
                String v11 = etn11.getText().toString();
                String v12 = etn12.getText().toString();
                String v13 = etn13.getText().toString();
                if (name.length()==0)
                {
                    etn1.requestFocus();
                    etn1.setError("FIELD CANNOT BE EMPTY");
                }
                else if (engine_type.length()==0)
                {
                    etn3.requestFocus();
                    etn3.setError("FIELD CANNOT BE EMPTY");
                }
                else if (!engine_type.equalsIgnoreCase("petrol")&&(!engine_type.equalsIgnoreCase("diesel")&&(!engine_type.equalsIgnoreCase("electric"))))
                {
                    etn3.requestFocus();
                    etn3.setError("INVALID INPUT");
                }
                else if(car_km.length()==0)
                {
                    etn4.requestFocus();
                    etn4.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v5.length()==0)
                {
                    etn5.requestFocus();
                    etn5.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v6.length()==0)
                {
                    etn6.requestFocus();
                    etn6.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v7.length()==0)
                {
                    etn7.requestFocus();
                    etn7.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v8.length()==0)
                {
                    etn8.requestFocus();
                    etn8.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v9.length()==0)
                {
                    etn9.requestFocus();
                    etn9.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v10.length()==0)
                {
                    etn10.requestFocus();
                    etn10.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v11.length()==0)
                {
                    etn11.requestFocus();
                    etn11.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v12.length()==0)
                {
                    etn12.requestFocus();
                    etn12.setError("FIELD CANNOT BE EMPTY");
                }
                else if(v13.length()==0)
                {
                    etn13.requestFocus();
                    etn13.setError("FIELD CANNOT BE EMPTY");
                }
                else if(!car_km.matches("[0-9]+"))
                {
                    etn4.requestFocus();
                    etn4.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v5.matches("[0-9]+"))
                {
                    etn5.requestFocus();
                    etn5.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v5.matches("[0-9]+"))
                {
                    etn5.requestFocus();
                    etn5.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v6.matches("[0-9]+"))
                {
                    etn6.requestFocus();
                    etn6.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v7.matches("[0-9]+"))
                {
                    etn7.requestFocus();
                    etn7.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v8.matches("[0-9]+"))
                {
                    etn8.requestFocus();
                    etn8.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v9.matches("[0-9]+"))
                {
                    etn9.requestFocus();
                    etn9.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v10.matches("[0-9]+"))
                {
                    etn10.requestFocus();
                    etn10.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v11.matches("[0-9]+"))
                {
                    etn11.requestFocus();
                    etn11.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v12.matches("[0-9]+"))
                {
                    etn12.requestFocus();
                    etn12.setError("ENTER ONLY NUMERICAL VALUES");
                }
                else if(!v13.matches("[0-9]+"))
                {
                    etn13.requestFocus();
                    etn13.setError("ENTER ONLY NUMERICAL VALUES");
                }

                else {
                    String[] values = calc();
                    Intent g = new Intent(inputActivity.this, finalActivity.class);
                    g.putExtra("SendOverValue", values);
                    startActivity(g);
                }


            }

        });
    }
}