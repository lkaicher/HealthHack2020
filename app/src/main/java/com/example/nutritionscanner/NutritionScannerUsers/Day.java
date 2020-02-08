package com.example.nutritionscanner.NutritionScannerUsers;

import java.util.Date;

/**
 * Day object holds meals, Breakfast, Dinner, Lunch, Snack and a Date object day.
 *
 */
public class Day {
    /**
     * Constructs a Day object with the given day
     * @param date Date object for the requested date
     */
    public Day(Date date){
        this.date=date;
    }
    private Meal Breakfast;
    private Meal Lunch;
    private Meal Dinner;
    private Meal Snack;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private Date date;

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

    /**
     * Gets total carbs for all meals this day so far
     * @return total carbs
     */
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

    /**
     * Gets total fat for all meals this day so far
     * @return total fat
     */
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

    /**
     * gets total protein for all meals this day so far
     * @return total protein
     */
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

    /**
     * gets total calories for the day so far
     * @return total calories
     */
    public int getCalories(){
        return getCarbs()+getFat()+getProtein();
    }

}
