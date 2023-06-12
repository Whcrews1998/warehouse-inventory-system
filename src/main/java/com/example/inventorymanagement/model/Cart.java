package com.example.inventorymanagement.model;

import com.example.inventorymanagement.entity.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> itemCart;
    private double totalPrice;

    public Cart() {
        itemCart = new ArrayList<Item>();
        totalPrice = 0;
    }

    public void addItem(Item item) {
        if (item == null) return;
        totalPrice += item.getPrice();
        itemCart.add(item);
    }

    public void removeItem(Item item) {
        if (!itemCart.remove(item)) return;
        totalPrice -= item.getPrice();
    }
}
