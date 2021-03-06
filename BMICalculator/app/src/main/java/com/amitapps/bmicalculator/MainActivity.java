package com.amitapps.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    //class Variables
    private TextView resultText;
    private Button calCulateButton;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageEditText;
    private EditText feetEditText;
    private EditText inchesEditText;
    private EditText weightEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Read layout file and show on the screen.

//find all the views or Values which will be give by users.
        findViews();

        //call the result button method.
        setUpButtonClickListner();

//        calCulateBMI();

//       displayResult(bmi);


    }

    private void findViews() {
        resultText = findViewById(R.id.text_view_result);
        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);
        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
        calCulateButton = findViewById(R.id.button_calculate);
    }

    private void setUpButtonClickListner() {
        calCulateButton.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View v) {
                                                   double bmiResult = calCulateBMI();
                                                   String ageText = ageEditText.getText().toString();
                                                   int age = Integer.parseInt(ageText);


                                                   if (age >= 18) {
                                                       displayResult(bmiResult);
                                                   } else {
                                                       disPlayGauidance(bmiResult);


                                                   }


                                               }
                                           }
        );
    }

    private void disPlayGauidance(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");

        String bmiTextValue = myDecimalFormatter.format(bmi);


        String fullResultString;


        if (maleButton.isChecked()) {

            fullResultString = bmiTextValue + "AS you are under 18,please consult with your doctor boys:";


        } else if (
                femaleButton.isChecked()) {
            fullResultString = bmiTextValue + "AS you are under 18,please consult with your doctor Girl:";

        } else {
            fullResultString = bmiTextValue + "AS you are under 18,please consult with your doctor for healthy Health:";

        }

        resultText.setText(fullResultString);

    }

    private double calCulateBMI() {

//
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();


//
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);


        int totalInches = (feet * 12) + inches;

        double heightInMeters = totalInches * 0.0254;
        double bmi = weight / (heightInMeters * heightInMeters);
        return bmi;
    }

    private void displayResult(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");

        String bmiTextValue = myDecimalFormatter.format(bmi);


        resultText.setText(bmiTextValue);

        String fullResultString;


        if (bmi < 19.5) {
            //display underWeight;


            fullResultString = bmiTextValue + " - You are underWeighted";


        } else if (bmi < 25) {

            fullResultString = bmiTextValue + "= You are OverWeighted";

        } else {

            fullResultString = bmiTextValue + "You are healthy men";

        }

        resultText.setText(fullResultString);
    }

}





