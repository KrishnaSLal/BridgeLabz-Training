package com.annotations.customcachingsystem;

import java.util.Scanner;

public class MainCustomCacheSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ExpensiveService service = new ExpensiveService();

        try {
            while (true) {
                System.out.print("\nEnter a number to compute square (or -1 to exit): ");
                int number = scanner.nextInt();

                if (number == -1) {
                    System.out.println("Exiting...");
                    break;
                }

                Object result = CacheManager.invokeWithCache(
                        service,
                        "computeSquare",
                        new Class[]{int.class},
                        new Object[]{number}
                );

                System.out.println("Result: " + result);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
