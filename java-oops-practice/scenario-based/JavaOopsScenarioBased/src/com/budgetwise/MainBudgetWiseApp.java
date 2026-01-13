package com.budgetwise;

import java.util.*;
import java.time.LocalDate;

public class MainBudgetWiseApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Budget Type (1-Monthly, 2-Annual): ");
        int choice = sc.nextInt();

        System.out.print("Enter Income: ");
        double income = sc.nextDouble();

        System.out.print("Enter Total Limit: ");
        double limit = sc.nextDouble();

        Map<String, Double> categoryLimits = new HashMap<>();

        System.out.print("Enter number of categories: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Category name: ");
            String cat = sc.next();
            System.out.print("Limit for " + cat + ": ");
            categoryLimits.put(cat, sc.nextDouble());
        }

        Budget budget;
        if (choice == 1) {
            budget = new MonthlyBudget(income, limit, categoryLimits);
        } else {
            budget = new AnnualBudget(income, limit, categoryLimits);
        }

        while (true) {
            System.out.println("\n1. Add Expense");
            System.out.println("2. Generate Report");
            System.out.println("3. Detect Overspend");
            System.out.println("4. Exit");
            System.out.print("Choice: ");

            int option = sc.nextInt();

            switch (option) {

                case 1:
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    System.out.print("Category: ");
                    String category = sc.next();
                    budget.addTransaction(new Transaction(
                            amt, "EXPENSE", LocalDate.now(), category));
                    break;

                case 2:
                    budget.generateReport();
                    break;

                case 3:
                    budget.detectOverspend();
                    break;

                case 4:
                    System.out.println("Exiting BudgetWise");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }
        }
    }
}
