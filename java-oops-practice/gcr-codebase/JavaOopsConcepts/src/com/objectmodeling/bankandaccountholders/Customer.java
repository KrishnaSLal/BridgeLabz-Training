package com.objectmodeling.bankandaccountholders;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    // Customer communicates with Account
    public void viewBalance() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            System.out.println("Bank: " + acc.getBank().getBankName()
                    + ", Balance: ₹" + acc.getBalance());
        }
    }

    public String getName() {
        return name;
    }
}
