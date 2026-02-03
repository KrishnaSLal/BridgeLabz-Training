package com.medinventory;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.*;

public class InventoryReader {

    private static final Pattern DATE_PATTERN =
            Pattern.compile("\\d{2}-\\d{2}-\\d{4}");

    public static Set<Item<String>> readInventory(File file)
            throws IOException, LowStockException {

        Set<Item<String>> items = new HashSet<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {

            String line;
            br.readLine(); 

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");
                if (data.length != 4) continue;

                String id = data[0];
                String name = data[1];
                int qty = Integer.parseInt(data[2]);
                String dateStr = data[3];

                Matcher matcher = DATE_PATTERN.matcher(dateStr);
                if (!matcher.matches()) continue;

                LocalDate expiry = LocalDate.parse(dateStr, formatter);

                if (qty < 10) {
                    throw new LowStockException("Critical stock for: " + name);
                }

                String category = classifyItem(name);
                items.add(new Item<>(id, name, qty, expiry, category));
            }
        }
        return items;
    }

    private static String classifyItem(String name) {
        if (name.toLowerCase().contains("glove")) return "Consumable";
        if (name.toLowerCase().contains("syringe")) return "Surgical";
        if (name.toLowerCase().contains("oxygen")) return "Equipment";
        return "Other";
    }
}
