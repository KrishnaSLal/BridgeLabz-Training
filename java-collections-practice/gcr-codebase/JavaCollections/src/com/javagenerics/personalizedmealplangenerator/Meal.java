package com.javagenerics.personalizedmealplangenerator;

class Meal<T extends MealPlan> {

	    private String userName;
	    private T mealPlan;

	    public Meal(String userName, T mealPlan) {
	        this.userName = userName;
	        this.mealPlan = mealPlan;
	    }

	    public T getMealPlan() {
	        return mealPlan;
	    }

	    public void displayMeal() {
	        System.out.println("User: " + userName + " | Meal Type: " + mealPlan.getMealType() + " | Calories: " + mealPlan.getCalories());
	    }
}
