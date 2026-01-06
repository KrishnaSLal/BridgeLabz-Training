package com.fittrack;

public class StrengthWorkout extends Workout {

    public StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    // Polymorphism
    @Override
    public void calculateCalories(double weight) {
        caloriesBurned = duration * weight * 0.06;
    }
}
