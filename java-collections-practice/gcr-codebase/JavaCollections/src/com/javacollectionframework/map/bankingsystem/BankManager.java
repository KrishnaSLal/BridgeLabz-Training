package com.javacollectionframework.map.bankingsystem;

import java.util.*;

public class BankManager {
    private Map<String, Double> accounts = new HashMap<>(); // AccountNumber -> Balance
    private TreeMap<Double, List<String>> balanceSortedAccounts = new TreeMap<>(); // Balance -> List of accounts
    private Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>(); // Queue of withdrawal requests

    // Create a new account
    public void createAccount(String accountNumber, double initialBalance) {
        if (accounts.containsKey(accountNumber)) {
            System.out.println("Account already exists!");
            return;
        }
        accounts.put(accountNumber, initialBalance);
        balanceSortedAccounts.computeIfAbsent(initialBalance, k -> new ArrayList<>()).add(accountNumber);
        System.out.println("Account created: " + accountNumber + " with balance $" + initialBalance);
    }

    // Deposit money
    public void deposit(String accountNumber, double amount) {
        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account does not exist!");
            return;
        }
        double oldBalance = accounts.get(accountNumber);
        double newBalance = oldBalance + amount;
        accounts.put(accountNumber, newBalance);

        // Update TreeMap
        List<String> oldList = balanceSortedAccounts.get(oldBalance);
        oldList.remove(accountNumber);
        if (oldList.isEmpty()) balanceSortedAccounts.remove(oldBalance);

        balanceSortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(accountNumber);

        System.out.println("Deposited $" + amount + " to account " + accountNumber);
    }

    // Add a withdrawal request to the queue
    public void requestWithdrawal(String accountNumber, double amount) {
        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        System.out.println("Withdrawal request added to queue for account " + accountNumber);
    }

    // Process the next withdrawal request
    public void processWithdrawal() {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawal requests in queue.");
            return;
        }

        WithdrawalRequest request = withdrawalQueue.poll();
        String acc = request.getAccountNumber();
        double amount = request.getAmount();

        if (!accounts.containsKey(acc)) {
            System.out.println("Account " + acc + " does not exist.");
            return;
        }

        double balance = accounts.get(acc);
        if (balance < amount) {
            System.out.println("Insufficient balance for account " + acc);
            return;
        }

        double newBalance = balance - amount;
        accounts.put(acc, newBalance);

        // Update TreeMap
        List<String> oldList = balanceSortedAccounts.get(balance);
        oldList.remove(acc);
        if (oldList.isEmpty()) balanceSortedAccounts.remove(balance);

        balanceSortedAccounts.computeIfAbsent(newBalance, k -> new ArrayList<>()).add(acc);

        System.out.println("Withdrawal of $" + amount + " processed for account " + acc);
    }

    // Display all accounts (HashMap)
    public void displayAccounts() {
        System.out.println("All accounts:");
        accounts.forEach((acc, bal) -> System.out.println(acc + " -> $" + bal));
    }

    // Display accounts sorted by balance (TreeMap)
    public void displayAccountsSortedByBalance() {
        System.out.println("Accounts sorted by balance:");
        balanceSortedAccounts.forEach((bal, accList) -> {
            for (String acc : accList) {
                System.out.println(acc + " -> $" + bal);
            }
        });
    }

    // Inner class for withdrawal requests
    private static class WithdrawalRequest {
        private String accountNumber;
        private double amount;

        public WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public double getAmount() {
            return amount;
        }
    }
}
