package com.example.nutritionscanner.NutritionScannerUsers;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.DAYS;

public class User implements Serializable {
    public static final double ACTIVE_MULTIPLIER = 1.375;
    public static final double INACTIVE_MULTIPLIER = 1.2;
    public static final int WEIGHT_GOAL_DIFF=300;
    private enum WeightGoal{
        LOSE, MAINTAIN, GAIN
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    private int weightLBs;
    private int heightInches;
    private int age;
    private ArrayList<Day> days;
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String gender;
    private boolean isActive;
    private WeightGoal goal;

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    /**
     * Computes caloric target for the day based on Harris Benedict Equation
     * @return caloric target for the day
     */
    public int getCaloricTarget(){
        double multiplier = INACTIVE_MULTIPLIER;
        if(isActive)
            multiplier = ACTIVE_MULTIPLIER;
        double kg = weightLBtoKG();
        double bmr;
        if (gender.toUpperCase().equals("MALE")){
            bmr = 66.4370 +(13.7516)*kg+5.0033*heightINtoCM()-6.7550*age;
        }
        else{
            bmr = 655.0955 + 9.5634*kg +1.84968*heightINtoCM()-4.6756*age;
        }
        if(this.goal==WeightGoal.GAIN){
            return (int)(multiplier*bmr)+WEIGHT_GOAL_DIFF;
        }
        else if (this.goal==WeightGoal.LOSE)
            return (int)(multiplier*bmr)-WEIGHT_GOAL_DIFF;
        else return (int)(multiplier*bmr);

    }
    private double weightLBtoKG(){
        return weightLBs /2.205;
    }
    private double heightINtoCM(){
        return heightInches*2.54;
    }
    public int getWeightLBs() {
        return weightLBs;
    }

    /**
     * Takes in goal and sets the goal enum to the desired goal
     * @param goal string for goal, case insensitive
     * @throws InvalidGoalException throws if the goal does not match "LOSE", "GAIN", or "MAINTAIN"
     */
    public void setGoal(String goal)throws InvalidGoalException {
        goal=goal.toUpperCase();
        switch(goal){
            case "LOSE":
                this.goal= WeightGoal.LOSE;
                break;
            case "GAIN":
                this.goal=WeightGoal.GAIN;
                break;
            case "MAINTAIN":
                this.goal=WeightGoal.MAINTAIN;
                break;
            default:
                throw new InvalidGoalException();
        }
    }
    public void setWeightLBs(int weightLBs) {
        this.weightLBs = weightLBs;
    }

    public int getHeightInches() {
        return heightInches;
    }

    public void setHeightInches(int heightInches) {
        this.heightInches = heightInches;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public User(){
        this.days=new ArrayList<>();
    }

    /**
     * Constructs a user object from given parameters
     * @param name name
     * @param age age
     * @param weight in pounds
     * @param heightInches height in inches
     * @param gender biological gender
     * @param isActive Are they physically active (moderate ativity 1-3 times a day) or sedentary
     */
    public User(String name, int age, int weight, int heightInches, String gender, boolean isActive){
        this.name=name;
        this.weightLBs =weight;
        this.heightInches=heightInches;
        this.gender=gender;
        this.isActive = isActive;
        this.age=age;
        this.days=new ArrayList<>();
    }

    /**
     * Updates the date array with the day object and its date
     * @param day Day object
     */
    public void addDay(Day day){
        if(days.size()==0)
            days.add(day);
        days.set((int)(days.get(0).getDate().getTime()-day.getDate().getTime())/86400000, day);
    }
}
