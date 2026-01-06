package com.fittrack;

import java.util.Scanner;

public class MainFitTrack {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // User input
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Weight (kg): ");
        double weight = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Fitness Goal (or press Enter for default): ");
        String goal = sc.nextLine();

        UserProfile user;
        if (goal.isEmpty()) {
            user = new UserProfile(name, age, weight);
        } else {
            user = new UserProfile(name, age, weight, goal);
        }

        user.displayProfile();

        // Daily calorie target
        double dailyTarget = weight * 30;
        System.out.println("\nDaily Calorie Target: " + dailyTarget);

        // Workout choice
        System.out.println("\nChoose Workout Type:");
        System.out.println("1. Cardio");
        System.out.println("2. Strength");
        int choice = sc.nextInt();

        System.out.print("Enter duration (minutes): ");
        int duration = sc.nextInt();

        Workout workout;

        if (choice == 1) {
            workout = new CardioWorkout(duration);
        } else {
            workout = new StrengthWorkout(duration);
        }

        workout.startWorkout();
        workout.calculateCalories(user.getWeight());
        workout.stopWorkout();

        double burned = workout.getCaloriesBurned();
        double remaining = dailyTarget - burned;   // operator usage

        System.out.println("\nCalories Burned: " + burned);
        System.out.println("Remaining Calories to Burn: " + remaining);

        sc.close();
    }
}
