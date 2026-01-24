package com.javagenerics.personalizedmealplangenerator;

public class VegetarianMeal implements MealPlan {

    public String getMealType() {
        return "Vegetarian";
    }

    public int getCalories() {
        return 1800;
    }
}
class VeganMeal implements MealPlan {

    public String getMealType() {
        return "Vegan";
    }

    public int getCalories() {
        return 1600;
    }
}
class KetoMeal implements MealPlan {

    public String getMealType() {
        return "Keto";
    }

    public int getCalories() {
        return 2000;
    }
}
class HighProteinMeal implements MealPlan {

    public String getMealType() {
        return "High Protein";
    }

    public int getCalories() {
        return 2200;
    }
}
