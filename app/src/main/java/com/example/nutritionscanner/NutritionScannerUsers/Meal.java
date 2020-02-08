package com.example.nutritionscanner.NutritionScannerUsers;

public class Meal {
    private String type, food_name;
    private int calFat, calCarb, calProtein;

    public Meal(String mealTime, int calFat, int calCarb, int calProtein, String food_name) {
        this.calFat = calFat;
        this.calCarb = calCarb;
        this.calProtein = calProtein;
        this.food_name = food_name;
        this.type = mealTime;
    }

    public int getFat() {
        return calFat;
    }

    public String getFoodName() {
        return food_name;
    }

    public int getCarb() {
        return calCarb;
    }

    public int getProtein() {
        return calProtein;
    }

    public int getCalories() {
        return getCarb() + getFat() + getProtein();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "type='" + type + '\'' +
                ", food_name='" + food_name + '\'' +
                ", calFat=" + calFat +
                ", calCarb=" + calCarb +
                ", calProtein=" + calProtein +
                '}';
    }
}


