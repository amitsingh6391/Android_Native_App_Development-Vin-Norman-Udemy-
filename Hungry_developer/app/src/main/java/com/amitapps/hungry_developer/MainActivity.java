package com.amitapps.hungry_developer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

                Intent starterActivityIntent = new Intent(MainActivity.this, StartersActivity.class);
                startActivity(starterActivityIntent);

            }
        });


        mainsCard.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent mainCoursesActivityIntent = new Intent(MainActivity.this, MainCoursesActivity.class);
                startActivity(mainCoursesActivityIntent);

            }


        });

        TextView email = findViewById(R.id.text_view_email);

        email.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent launchEmailIntent = new Intent(Intent.ACTION_SENDTO);

                launchEmailIntent.setData(Uri.parse("mailto:amitsingh954858@gmail.com")); //here only email will be opened;


                startActivity(launchEmailIntent);

            }
        });
    }
}
