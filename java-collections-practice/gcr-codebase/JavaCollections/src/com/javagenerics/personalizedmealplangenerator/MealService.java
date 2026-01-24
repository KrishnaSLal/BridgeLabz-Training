package com.javagenerics.personalizedmealplangenerator;

public class MealService {

    public static <T extends MealPlan> Meal<T> generateMealPlan(
            String userName, T mealPlan) {

        if (mealPlan.getCalories() < 1500 || mealPlan.getCalories() > 2500) {
            throw new IllegalArgumentException("Invalid calorie range!");
        }

        return new Meal<>(userName, mealPlan);
    }
}
