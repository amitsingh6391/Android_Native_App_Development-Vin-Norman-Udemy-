package com.amitapps.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
                                                   calCulateBMI();
                                               }
                                           }
        );
    }

    private void calCulateBMI() {

        String ageText = ageEditText.getText().toString();
        String feetText = feetEditText.getText().toString();
        String inchesText = inchesEditText.getText().toString();
        String weightText = weightEditText.getText().toString();



        int age = Integer.parseInt(ageText);
        int feet = Integer.parseInt(feetText);
        int inches = Integer.parseInt(inchesText);
        int weight = Integer.parseInt(weightText);


        int totalInches = (feet*12)+inches;

        double heightInMeters = totalInches*0.0254;
        double bmi = weight/(heightInMeters*heightInMeters);

        String bmiTextValue = String.valueOf(bmi);


        resultText.setText(bmiTextValue);


    }


}
