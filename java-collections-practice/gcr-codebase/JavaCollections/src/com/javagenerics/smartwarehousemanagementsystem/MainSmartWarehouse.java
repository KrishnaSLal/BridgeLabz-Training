package com.javagenerics.smartwarehousemanagementsystem;

import java.util.List;
import java.util.Scanner;

public class MainSmartWarehouse {

    // Wildcard method
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getName() + " - " + item.getCategory());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceryStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        System.out.print("Enter number of electronics items: ");
        int eCount = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < eCount; i++) {
            System.out.print("Enter electronics item name: ");
            String name = sc.nextLine();
            electronicsStorage.addItem(new Electronics(name));
        }

        System.out.print("\nEnter number of grocery items: ");
        int gCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < gCount; i++) {
            System.out.print("Enter grocery item name: ");
            String name = sc.nextLine();
            groceryStorage.addItem(new Groceries(name));
        }

        System.out.print("\nEnter number of furniture items: ");
        int fCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < fCount; i++) {
            System.out.print("Enter furniture item name: ");
            String name = sc.nextLine();
            furnitureStorage.addItem(new Furniture(name));
        }

        System.out.println("\nElectronics Storage");
        displayItems(electronicsStorage.getItems());

        System.out.println("\nGroceries Storage");
        displayItems(groceryStorage.getItems());

        System.out.println("\nFurniture Storage");
        displayItems(furnitureStorage.getItems());

        sc.close();
    }
}
