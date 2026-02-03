//6. MedInventory – Smart Hospital Inventory Tracker
//Story: At Apollo International Hospital, a new system called MedInventory is being built to track
//medical supplies such as gloves, syringes, and oxygen cylinders.
//Every morning, the inventory data is dumped as a .csv file containing:
//ItemID,ItemName,Quantity,ExpiryDate
//The Java system must:
//● Read inventory files using BufferedReader (I/O Streams)
//● Detect expired items using Regex on the ExpiryDate field (dd-MM-yyyy)
//● Categorize items by type using Map<String, List<Item>>
//● Remove duplicates using Set<Item> based on item ID
//● Use Generics to allow extension to surgical tools, medicines, etc.
//● Raise custom exceptions for critically low supplies



package com.medinventory;

import java.io.File;
import java.time.LocalDate;
import java.util.*;

public class MainMedInventory {

    public static void main(String[] args) {

        File file = new File("C:\\Users\\krish\\OneDrive\\Desktop\\BridgeLabz-Training\\java-collections-practice\\scenario-based\\JavaCollectionScenarioBased\\src\\com\\medinventory\\inventory.csv");

        try {
            Set<Item<String>> inventory = InventoryReader.readInventory(file);

            Map<String, List<Item<String>>> categorized = new HashMap<>();

            for (Item<String> item : inventory) {
                categorized.computeIfAbsent(item.getCategory(), k -> new ArrayList<>()).add(item);
            }

            System.out.println("\nCategorized Inventory:");
            categorized.forEach((k, v) -> {
                System.out.println("\n" + k + ":");
                v.forEach(System.out::println);
            });

            System.out.println("\nExpired Items:");
            inventory.stream().filter(i -> i.getExpiryDate().isBefore(LocalDate.now())).forEach(System.out::println);

        } catch (LowStockException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}