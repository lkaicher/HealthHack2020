package com.example.nutritionscanner;

import org.json.JSONObject;

public class FoodItem {

    private String name;
    private int calories, protein, totalFat, saturatedFat, sodium, fiber;

    public FoodItem(JSONObject info) {
        try {
            name = info.getString("food_name");
            calories = info.getInt("nf_calories");
            protein = info.getInt("nf_protein");
            totalFat = info.getInt("nf_total_fat");
            saturatedFat = info.getInt("nf_saturated_fat");
            sodium = info.getInt("nf_sodium");
            fiber = info.getInt("nf_dietary_fiber");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int getProtein() {
        return protein;
    }

    public int getFiber() {
        return fiber;
    }

    public int getSodium() {
        return sodium;
    }

    public int getCalories() {
        return calories;
    }

    public int getSaturatedFat() {
        return saturatedFat;
    }

    public int getTotalFat() {
        return totalFat;
    }

    public String getName() {
        return name;
    }
}
