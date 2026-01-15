package com.smartcheckout;

import java.util.HashMap;

public class Inventory {

    private HashMap<String, Item> itemMap = new HashMap<>();

    public void addItem(String name, double price, int stock) {
        itemMap.put(name, new Item(name, price, stock));
    }

    public Item getItem(String name) {
        return itemMap.get(name);
    }

    public void updateStock(String name, int qty) {
        Item item = itemMap.get(name);
        if (item != null) {
            item.stock -= qty;
        }
    }
}
