package com.payxpress;

import java.time.LocalDate;
import java.util.Scanner;

public class MainPayXpress {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bill bill = null;
        int choice;

        do {
            System.out.println("PayXpress Menu: ");
            System.out.println("1. Create Electricity Bill");
            System.out.println("2. Create Water Bill");
            System.out.println("3. Create Internet Bill");
            System.out.println("4. Pay Bill");
            System.out.println("5. Send Reminder");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                case 2:
                case 3:
                    System.out.print("Enter bill amount: ");
                    double amount = sc.nextDouble();

                    System.out.print("Enter due days from today: ");
                    int days = sc.nextInt();

                    LocalDate dueDate = LocalDate.now().plusDays(days);

                    if (choice == 1)
                        bill = new ElectricityBill(amount, dueDate);
                    else if (choice == 2)
                        bill = new WaterBill(amount, dueDate);
                    else
                        bill = new InternetBill(amount, dueDate);

                    System.out.println("Bill created successfully!");
                    break;

                case 4:
                    if (bill != null)
                        bill.pay();
                    else
                        System.out.println("No bill created yet!");
                    break;

                case 5:
                    if (bill != null)
                        bill.sendReminder();
                    else
                        System.out.println("No bill created yet!");
                    break;

                case 6:
                    System.out.println("Exiting PayXpress");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 6);

        sc.close();
    }
}
