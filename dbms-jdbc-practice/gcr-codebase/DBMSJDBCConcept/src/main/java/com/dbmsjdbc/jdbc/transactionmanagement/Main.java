package com.dbmsjdbc.jdbc.transactionmanagement;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.initialize();
        BankingDAO dao = new BankingDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n1. Transfer Money");
            System.out.println("2. Check Balance");
            System.out.println("3. Transaction History");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("From Account ID: ");
                    int from = sc.nextInt();
                    System.out.print("To Account ID: ");
                    int to = sc.nextInt();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    dao.transferMoney(from, to, amount);
                    break;

                case 2:
                    System.out.print("Account ID: ");
                    int id = sc.nextInt();
                    dao.checkBalance(id);
                    break;

                case 3:
                    dao.viewHistory();
                    break;

                case 4:
                    System.exit(0);
            }
        }
    }
}