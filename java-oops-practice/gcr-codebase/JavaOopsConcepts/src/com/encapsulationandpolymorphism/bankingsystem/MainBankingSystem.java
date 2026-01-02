package com.encapsulationandpolymorphism.bankingsystem;

import java.util.ArrayList;
import java.util.List;

public class MainBankingSystem {

    public static void main(String[] args) {

        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SB1001", "Amit", 80000);
        BankAccount acc2 = new CurrentAccount("CA2001", "Neha", 40000);

        accounts.add(acc1);
        accounts.add(acc2);

        for (BankAccount acc : accounts) {

            acc.displayAccountDetails();
            System.out.println("Interest: ₹" + acc.calculateInterest());

            if (acc instanceof Loanable) {
                Loanable loanAcc = (Loanable) acc;
                loanAcc.applyForLoan(200000);
                System.out.println("Loan Eligible: " + loanAcc.calculateLoanEligibility());
            }

            System.out.println("--------------------------");
        }
    }
}
