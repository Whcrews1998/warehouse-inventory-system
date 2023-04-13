package com.example.inventorymanagement.model;

import com.example.inventorymanagement.embeddable.Location;
import com.example.inventorymanagement.entity.Item;

public class ItemDetails {
    private Integer id;

    private Location location;
    private SubcategoryDetails subcategoryDetails;

    private double price;
    private int quantity;
    private String description;

    private int minInvLevel;
    private int maxInvLevel;

    // Methods
    public Item createItemEntity() {
        Item item = new Item();
        item.setLocation(this.location);
        item.setDescription(this.description);
        item.setPrice(this.price);
        item.setQuantity(this.quantity);
        item.setMaxInvLevel(this.maxInvLevel);
        item.setMinInvLevel(this.minInvLevel);
        item.setSubcategory(this.subcategoryDetails.createSubcategoryEntity());

        return item;
    }

    // Getter Setters Constructor
    public ItemDetails() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public SubcategoryDetails getSubcategoryDetails() {
        return subcategoryDetails;
    }

    public void setSubcategoryDetails(SubcategoryDetails subcategoryDetails) {
        this.subcategoryDetails = subcategoryDetails;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinInvLevel() {
        return minInvLevel;
    }

    public void setMinInvLevel(int minInvLevel) {
        this.minInvLevel = minInvLevel;
    }

    public int getMaxInvLevel() {
        return maxInvLevel;
    }

    public void setMaxInvLevel(int maxInvLevel) {
        this.maxInvLevel = maxInvLevel;
    }
}
