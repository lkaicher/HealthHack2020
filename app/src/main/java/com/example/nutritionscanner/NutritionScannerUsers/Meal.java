package com.example.nutritionscanner.NutritionScannerUsers;

public class Meal {
    enum Type {
        BREAKFAST, LUNCH, DINNER, SNACK
    }
    Type type;
    int calFat,  calCarb,  calProtein;
    String food_name;
    public Meal(String mealTime, int calFat, int calCarb, int calProtein, String food_name){
        this.calFat = calFat;
        this.calCarb = calCarb;
        this.calProtein = calProtein;
        this.food_name = food_name;
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

    public Type getType() {
        return type;
    }

    public int getFat(){
        return calFat;
    }
    public String getFoodName() {
        return food_name;
    }
    public int getCarb(){
        return calCarb;
    }
    public int getProtein(){
        return calProtein;
    }
    public int getCalories(){
        return getCarb()+getFat()+getProtein();
    }

}


