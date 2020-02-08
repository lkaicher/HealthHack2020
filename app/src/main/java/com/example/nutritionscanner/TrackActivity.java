package com.example.nutritionscanner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.nutritionscanner.NutritionScannerUsers.Meal;
import com.example.nutritionscanner.storage.BasicStorage;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TrackActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.list);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Meal meal = new Meal("BREAKFAST", 1, 1, 1, "Tacos");
        Meal meal2 = new Meal("LUNCH", 2, 2, 2, "Logs");
        List<Meal> mealList = new ArrayList<>();
        mealList.add(meal);
        mealList.add(meal2);
        BasicStorage basicStorage = new BasicStorage();
        List<Meal> savedMeals = basicStorage.readData(TrackActivity.this);
        Log.d("MSG", "savedMeal:" + savedMeals);
        if (savedMeals != null) {
            mealList.addAll(savedMeals);
        }
        mAdapter = new MyAdapter(mealList);
        recyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrackActivity.this, MainActivity.class));
            }
        });
    }

}
