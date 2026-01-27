package com.annotations.suppresswarning;

import java.util.ArrayList;
import java.util.Scanner;

public class MainSuppressWarning {

    @SuppressWarnings("unchecked") // Suppresses raw type warnings
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Raw ArrayList (no generics)
            ArrayList list = new ArrayList();

            System.out.print("How many elements do you want to add? ");
            int n = scanner.nextInt();
            scanner.nextLine(); // consume newline

            for (int i = 0; i < n; i++) {
                System.out.print("Enter element " + (i + 1) + ": ");
                String element = scanner.nextLine();
                list.add(element); // unchecked warning would normally appear
            }

            System.out.println("\nElements in the ArrayList:");
            for (Object obj : list) {
                System.out.println(obj);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
