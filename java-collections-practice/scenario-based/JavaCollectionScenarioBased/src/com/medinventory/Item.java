package com.medinventory;

import java.time.LocalDate;
import java.util.Objects;

public class Item<T> {

    private String itemId;
    private String itemName;
    private int quantity;
    private LocalDate expiryDate;
    private T category;

    public Item(String itemId, String itemName, int quantity, LocalDate expiryDate, T category) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.expiryDate = expiryDate;
        this.category = category;
    }

    public String getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public T getCategory() {
        return category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item<?> item = (Item<?>) o;
        return Objects.equals(itemId, item.itemId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemId);
    }

    @Override
    public String toString() {
        return itemName + " | Qty: " + quantity + " | Exp: " + expiryDate;
    }
}
