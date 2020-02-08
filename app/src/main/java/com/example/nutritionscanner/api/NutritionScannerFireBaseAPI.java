package com.example.nutritionscanner.api;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NutritionScannerFireBaseAPI {
    public void addUser(String name, int height, int weight, String gender){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myref = database.getReference("message");
    }
}
