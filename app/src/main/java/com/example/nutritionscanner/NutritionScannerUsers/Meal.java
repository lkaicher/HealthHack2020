package com.example.nutritionscanner.NutritionScannerUsers;

public class Meal {
    enum Type {
        BREAKFAST, LUNCH, DINNER, SNACK
    }
    Type type;
    private int[] numCalories;
    public Meal(String mealTime, int calFat, int calCarb, int calProtein){
        int[] numCalories = new int[]{calFat, calCarb, calProtein};
        mealTime=mealTime.toUpperCase();
        switch(mealTime){
            case "BREAKFAST":
                type=Type.BREAKFAST;
                break;
            case "LUNCH":
                type = Type.LUNCH;
                break;
            case "DINNER":
                type = Type.DINNER;
                break;
            default:
                type = Type.SNACK;
        }
    }
    public int getFat(){
        return numCalories[0];
    }
    public int getCarb(){
        return numCalories[1];
    }
    public int getProtein(){
        return numCalories[2];
    }
    }


