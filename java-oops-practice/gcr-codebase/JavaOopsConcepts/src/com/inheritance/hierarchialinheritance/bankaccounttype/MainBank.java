package com.inheritance.hierarchialinheritance.bankaccounttype;

public class MainBank {
	public static void main(String[] args) {

        BankAccount acc1 = new SavingsAccount("SB101", 50000, 4.5);
        BankAccount acc2 = new CheckingAccount("CA202", 30000, 10000);
        BankAccount acc3 = new FixedDepositAccount("FD303", 100000, 24);

        acc1.displayAccountType();
        acc1.displayDetails();
        System.out.println();

        acc2.displayAccountType();
        acc2.displayDetails();
        System.out.println();

        acc3.displayAccountType();
        acc3.displayDetails();
    }
}
