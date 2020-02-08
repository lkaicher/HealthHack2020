package com.example.nutritionscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.nutritionscanner.NutritionScannerUsers.Meal;

import java.util.ArrayList;
import java.util.List;

public class FoodList extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list);
        recyclerView = (RecyclerView) findViewById(R.id.list);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Meal meal = new Meal("BREAKFAST", 1,1,1, "Tacos");
        Meal meal2 = new Meal("LUNCH", 2,2,2, "Logs");
        List<Meal> mealList = new ArrayList<>();
        mealList.add(meal);
        mealList.add(meal2);
        mAdapter = new MyAdapter(mealList);
        recyclerView.setAdapter(mAdapter);
    }
}
