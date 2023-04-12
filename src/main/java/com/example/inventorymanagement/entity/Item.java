package com.example.inventorymanagement.entity;

import com.example.inventorymanagement.embeddable.Location;
import jakarta.persistence.*;

@Entity
public class Item {
    @Id
    @GeneratedValue
    private Integer id;

    @Embedded
    private Location location;

    @ManyToOne
    private Subcategory subcategory;

    private double price;
    private int quantity;
    private String description;

    private int minInvLevel;
    private int maxInvLevel;

    public Item() {
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

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
// TODO: Implement Getter/Setter/Constructor