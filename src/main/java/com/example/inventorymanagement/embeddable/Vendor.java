package com.example.inventorymanagement.embeddable;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public class Vendor {
    private String name;
    private Location location;

    public Vendor() {
    }

    public Vendor(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
