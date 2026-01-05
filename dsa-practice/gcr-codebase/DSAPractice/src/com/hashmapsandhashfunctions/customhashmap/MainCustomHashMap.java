package com.hashmapsandhashfunctions.customhashmap;

import java.util.Scanner;

public class MainCustomHashMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomHashMap map = new CustomHashMap(5);

        while (true) {
            System.out.println("\n1. Put");
            System.out.println("2. Get");
            System.out.println("3. Remove");
            System.out.println("4. Display");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key (int): ");
                    int key = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter value (String): ");
                    String value = scanner.nextLine();
                    map.put(key, value);
                    break;

                case 2:
                    System.out.print("Enter key to retrieve: ");
                    key = scanner.nextInt();
                    String result = map.get(key);
                    System.out.println(result != null ? "Value: " + result : "Key not found.");
                    break;

                case 3:
                    System.out.print("Enter key to remove: ");
                    key = scanner.nextInt();
                    map.remove(key);
                    break;

                case 4:
                    map.display();
                    break;

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
