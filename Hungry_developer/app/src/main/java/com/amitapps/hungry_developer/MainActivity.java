package com.amitapps.hungry_developer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    CardView starterCard;
    CardView mainsCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        starterCard = findViewById(R.id.card_view_card_view_starter);
        mainsCard = findViewById(R.id.card_view_main_courses);


        starterCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //we will navigate to new screen.

                Intent starterActivityIntent = new Intent(MainActivity.this,StartersActivity.class);
                startActivity(starterActivityIntent);

            }
        });
    }
}
