/*
Assignment: In Class Assignment 02
File name: MainActivity.java
Full name:
Akhil Madhamshetty-801165622
Tarun thota-801164383
 */

package com.example.inclass02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText bmiweight,bmifeet,bmiinches;
    private TextView bmiresult,bmiverdict;
    Button btncalculate;
    double weight;
    int feet,inches;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight=0;
        feet=0;
        inches=0;
        bmiweight=findViewById(R.id.bmiweight);
        bmifeet=findViewById(R.id.bmifeet);
        bmiinches=findViewById(R.id.bminches);
        bmiresult=findViewById(R.id.bmiresult);
        btncalculate=findViewById(R.id.calbutton);
        bmiverdict=findViewById(R.id.bmiverdict);
        btncalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String weight_text=bmiweight.getText().toString();
                String feet_text=bmifeet.getText().toString();
                String inches_text=bmiinches.getText().toString();

                if(weight_text.equals("")) {
                    bmiweight.setError("Can't be Empty");
                }
                else {
                    weight = Double.parseDouble(weight_text);

                }
                if(feet_text.equals("")){
                    bmifeet.setError("Can't be Empty");

                }
                else{
                    feet = Integer.parseInt(feet_text);

                }
                if(inches_text.equals("")){
                    bmiinches.setError("Can't be Empty");
                }
                else{
                    inches=Integer.parseInt(inches_text);

                }
                inches =inches + feet*12;
                double bmi = weight/inches/inches*703;
                bmiresult.setText("Your BMI:" + String.format("%.2f",bmi));
                Toast.makeText(MainActivity.this,"BMI Calculated",Toast.LENGTH_SHORT).show();
                if(bmi<18.5){
                    bmiverdict.setText("You are Underweight");
                }
                else if(bmi>18.5 && bmi<24.9){
                    bmiverdict.setText("You are Normal weight");
                }
                else if(bmi>24.9 && bmi<29.9){
                    bmiverdict.setText("You are Overweight");
                }
                else if(bmi>29.9){
                    bmiverdict.setText("You are Obese");
                }
            }
        });

    }
}
