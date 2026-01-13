package com.budgetwise;

import java.util.Map;
import java.util.HashMap;

class MonthlyBudget extends Budget {

    public MonthlyBudget(double income, double limit, Map<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("\n📅 MONTHLY BUDGET REPORT");
        System.out.println("Income: " + income);
        System.out.println("Net Savings: " + calculateNetSavings());
    }

    @Override
    public void detectOverspend() {
        Map<String, Double> spent = new HashMap<>();

        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("EXPENSE")) {
                spent.put(t.getCategory(),
                        spent.getOrDefault(t.getCategory(), 0.0) + t.getAmount());
            }
        }

        for (String cat : spent.keySet()) {
            if (spent.get(cat) > categoryLimits.get(cat)) {
                System.out.println("⚠ Overspent in " + cat);
            }
        }
    }
}
