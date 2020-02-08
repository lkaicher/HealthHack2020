package com.example.nutritionscanner.storage;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.nutritionscanner.NutritionScannerUsers.Meal;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicStorage {

    public void saveData(Activity activity, Meal meal) {
        List<Meal> mealList = readData(activity);
        if(mealList == null) {
            mealList = new ArrayList<>();
        }
        System.out.println("Meal saving:" +meal);
        mealList.add(meal);
        Gson gson = new Gson();
        String data = gson.toJson(mealList);
        SharedPreferences.Editor editor = activity.getSharedPreferences("SharedPref", Context.MODE_PRIVATE).edit();
        editor.putString("meal", data);
        editor.apply();
    }

    public List<Meal> readData(Activity activity) {
//        Activity activity = (Activity) context;
        Gson gson = new Gson();
        SharedPreferences sharedPref = activity.getSharedPreferences("SharedPref", Context.MODE_PRIVATE);
        String data = sharedPref.getString("meal","");
        System.out.println(data);
        Meal[] meals = gson.fromJson(data, Meal[].class);
        System.out.println("meals cast:  "+meals);
        List<Meal> mealList = new ArrayList<>();
        if(meals != null && meals.length > 0) {
            mealList.addAll(Arrays.asList(meals));
        }
        return mealList;
    }
}
