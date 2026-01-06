package com.fittrack;

public class CardioWorkout extends Workout {

    public CardioWorkout(int duration) {
        super("Cardio", duration);
    }

    // Polymorphism
    @Override
    public void calculateCalories(double weight) {
        caloriesBurned = duration * weight * 0.08;
    }
}
