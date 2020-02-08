package com.example.nutritionscanner.NutritionScannerUsers;

import java.util.Date;

/**
 * Day object holds meals, Breakfast, Dinner, Lunch, Snack and a Date object day.
 */
public class Day {
    /**
     * Constructs a Day object with the given day
     *
     * @param date Date object for the requested date
     */
    public Day(Date date) {
        this.date = date;
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
     *
     * @return total carbs
     */
    public int getTotalCarbs() {
        int carbs = 0;
        if (Breakfast != null)
            carbs += Breakfast.getCarb();
        if (Lunch != null)
            carbs += Lunch.getCarb();
        if (Dinner != null)
            carbs += Dinner.getCarb();
        if (Snack != null)
            carbs += Snack.getCarb();
        return carbs;
    }

    /**
     * Gets total fat for all meals this day so far
     *
     * @return total fat
     */
    public int getTotalFat() {
        int fat = 0;
        if (Breakfast != null)
            fat += Breakfast.getFat();
        if (Lunch != null)
            fat += Lunch.getFat();
        if (Dinner != null)
            fat += Dinner.getFat();
        if (Snack != null)
            fat += Snack.getFat();
        return fat;
    }

    /**
     * gets total protein for all meals this day so far
     *
     * @return total protein
     */
    public int getTotalProtein() {
        int protein = 0;
        if (Breakfast != null)
            protein += Breakfast.getProtein();
        if (Lunch != null)
            protein += Lunch.getProtein();
        if (Dinner != null)
            protein += Dinner.getProtein();
        if (Snack != null)
            protein += Snack.getProtein();
        return protein;
    }

    /**
     * gets total calories for the day so far
     *
     * @return total calories
     */
    public int getTotalCalories() {
        return getTotalCarbs() * 4 + getTotalFat() * 8 + getTotalProtein() * 4;
    }

}
