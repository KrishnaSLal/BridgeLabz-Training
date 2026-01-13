package com.budgetwise;

import java.util.*;

abstract class Budget implements IAnalyzable {
    protected double income;
    protected double limit;
    protected Map<String, Double> categoryLimits;
    protected List<Transaction> transactions;

    public Budget(double income, double limit, Map<String, Double> categoryLimits) {
        this.income = income;
        this.limit = limit;
        this.categoryLimits = categoryLimits;
        this.transactions = new ArrayList<>();
    }

    // Controlled way to add expense
    public void addTransaction(Transaction t) {
        transactions.add(t);
    }

    // Operator logic: income - totalExpenses
    public double calculateNetSavings() {
        double expense = 0;
        for (Transaction t : transactions) {
            if (t.getType().equalsIgnoreCase("EXPENSE")) {
                expense += t.getAmount();
            }
        }
        return income - expense;
    }
}
