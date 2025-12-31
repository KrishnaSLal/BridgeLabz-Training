package com.objectmodeling.bankandaccountholders;

public class BankMain {
	 public static void main(String[] args) {

	        Bank sbi = new Bank("State Bank of India");
	        Bank hdfc = new Bank("HDFC Bank");

	        Customer rahul = new Customer("Rahul");

	        Account acc1 = sbi.openAccount(rahul, 101);
	        Account acc2 = hdfc.openAccount(rahul, 202);

	        acc1.deposit(5000);
	        acc2.deposit(10000);

	        rahul.viewBalance();
	    }
}
