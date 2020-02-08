package com.example.nutritionscanner.api;

import androidx.annotation.NonNull;

import com.example.nutritionscanner.NutritionScannerUsers.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

public class NutritionScannerFireBaseAPI {


    public void addUser(User user){
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("");
        myRef.setValue(user);
        String key = myRef.child("name").push().getKey();
        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("user", user);
        myRef.updateChildren(childUpdates);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                System.out.println(user.getName());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        myRef.child("user").removeValue();


    }
}
