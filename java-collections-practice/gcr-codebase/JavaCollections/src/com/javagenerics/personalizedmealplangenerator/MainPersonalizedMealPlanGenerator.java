package com.javagenerics.personalizedmealplangenerator;

import java.util.Scanner;

public class MainPersonalizedMealPlanGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter user name: ");
        String userName = sc.nextLine();

        System.out.println("\nSelect Meal Category:");
        System.out.println("1. Vegetarian");
        System.out.println("2. Vegan");
        System.out.println("3. Keto");
        System.out.println("4. High Protein");
        System.out.print("Enter choice: ");

        int choice = sc.nextInt();

        try {
            switch (choice) {

                case 1:
                    Meal<VegetarianMeal> vegMeal =
                            MealService.generateMealPlan(
                                    userName, new VegetarianMeal());
                    vegMeal.displayMeal();
                    break;

                case 2:
                    Meal<VeganMeal> veganMeal =
                            MealService.generateMealPlan(
                                    userName, new VeganMeal());
                    veganMeal.displayMeal();
                    break;

                case 3:
                    Meal<KetoMeal> ketoMeal =
                            MealService.generateMealPlan(
                                    userName, new KetoMeal());
                    ketoMeal.displayMeal();
                    break;

                case 4:
                    Meal<HighProteinMeal> proteinMeal =
                            MealService.generateMealPlan(
                                    userName, new HighProteinMeal());
                    proteinMeal.displayMeal();
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}
