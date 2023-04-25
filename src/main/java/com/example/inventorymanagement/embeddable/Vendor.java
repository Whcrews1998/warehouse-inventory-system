package com.example.inventorymanagement.embeddable;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Embeddable
public class Vendor {
    @Column(name="vendor_name")
    private String name;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="street", column=@Column(name="vendor_street")),
            @AttributeOverride(name="state", column=@Column(name="vendor_state")),
            @AttributeOverride(name="city", column=@Column(name="vendor_city")),
            @AttributeOverride(name="zipCode", column=@Column(name="vendor_zip_code")),
    })
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
