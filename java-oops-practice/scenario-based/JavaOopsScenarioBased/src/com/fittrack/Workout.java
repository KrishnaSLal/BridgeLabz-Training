package com.fittrack;

public abstract class Workout implements ITrackable {

    protected String type;
    protected int duration;          // in minutes
    protected double caloriesBurned;

    // internal logs (not exposed)
    protected String workoutLog;

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
        this.workoutLog = "Workout Started";
    }

    public abstract void calculateCalories(double weight);

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public void startWorkout() {
        System.out.println(type + " workout started.");
    }

    @Override
    public void stopWorkout() {
        workoutLog = "Workout Completed";
        System.out.println(type + " workout stopped.");
    }
}
