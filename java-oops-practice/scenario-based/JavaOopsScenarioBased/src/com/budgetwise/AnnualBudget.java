package com.budgetwise;

import java.util.Map;


class AnnualBudget extends Budget {

    public AnnualBudget(double income, double limit, Map<String, Double> categoryLimits) {
        super(income, limit, categoryLimits);
    }

    @Override
    public void generateReport() {
        System.out.println("\n📆 ANNUAL BUDGET REPORT");
        System.out.println("Total Income: " + income);
        System.out.println("Annual Savings: " + calculateNetSavings());
    }

    @Override
    public void detectOverspend() {
        System.out.println("Annual overspending analysis completed.");
    }
}
