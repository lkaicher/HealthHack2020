package com.example.nutritionscanner.NutritionScannerUsers;

public class Day {
    private Meal Breakfast;
    private Meal Lunch;
    private Meal Dinner;
    private Meal Snack;

    public Meal getBreakfast() {
        return Breakfast;
    }

    public void setBreakfast(Meal breakfast) {
        Breakfast = breakfast;
    }

    public Meal getLunch() {
        return Lunch;
    }

    public void setLunch(Meal lunch) {
        Lunch = lunch;
    }

    public Meal getDinner() {
        return Dinner;
    }

    public void setDinner(Meal dinner) {
        Dinner = dinner;
    }

    public Meal getSnack() {
        return Snack;
    }

    public void setSnack(Meal snack) {
        Snack = snack;
    }
    public int getCarbs(){
        int carbs = 0;
        if(Breakfast!=null)
            carbs+=Breakfast.getCarb();
        if(Lunch!=null)
            carbs+=Lunch.getCarb();
        if(Dinner!=null)
            carbs+=Dinner.getCarb();
        if(Snack!=null)
            carbs+=Snack.getCarb();
        return carbs;
    }
    public int getFat(){
        int carbs = 0;
        if(Breakfast!=null)
            carbs+=Breakfast.getFat();
        if(Lunch!=null)
            carbs+=Lunch.getFat();
        if(Dinner!=null)
            carbs+=Dinner.getFat();
        if(Snack!=null)
            carbs+=Snack.getFat();
        return carbs;
    }
    public int getProtein(){
        int carbs = 0;
        if(Breakfast!=null)
            carbs+=Breakfast.getProtein();
        if(Lunch!=null)
            carbs+=Lunch.getProtein();
        if(Dinner!=null)
            carbs+=Dinner.getProtein();
        if(Snack!=null)
            carbs+=Snack.getProtein();
        return carbs;
    }
    public int getCalories(){
        return getCarbs()+getFat()+getProtein();
    }

}
