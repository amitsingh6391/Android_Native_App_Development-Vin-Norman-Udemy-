package com.amitapps.portfolio;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView list = findViewById(R.id.recycle_view_project);


        Project gettingStarterProject = new Project("Academic mater", "this is E-learning app", 121212);

        Project[] projects = {

                new Project("GEtting started app ", "this is start app with java", R.drawable.getting_started),
                new Project("Amit Quates", "this is quates for developer", R.drawable.quote),
                new Project("Convertor", "this is app to inches to feet", R.drawable.tape),
                new Project("BMI", "this app for calculate the bmi for human", R.drawable.calculator),
                new Project("Hungry Developer", "this is Resturant app", R.drawable.hungry_developer),

        };


        ProjectsAdapter projectsAdapter = new ProjectsAdapter(projects);

        list.setAdapter(projectsAdapter);

    }
}

