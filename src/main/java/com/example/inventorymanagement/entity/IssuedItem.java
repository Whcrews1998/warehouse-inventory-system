package com.example.inventorymanagement.entity;

import com.example.inventorymanagement.embeddable.Location;
import jakarta.persistence.*;

@Entity
public class IssuedItem {
    @Id
    @GeneratedValue
    private Integer id;

    @OneToOne
    private Item item;

    @Embedded
    private Location issuedLocation;

    private int issuedQuantity;

    public IssuedItem() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location getIssuedLocation() {
        return issuedLocation;
    }

    public void setIssuedLocation(Location issuedLocation) {
        this.issuedLocation = issuedLocation;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getIssuedQuantity() {
        return issuedQuantity;
    }

    public void setIssuedQuantity(int issuedQuantity) {
        this.issuedQuantity = issuedQuantity;
    }
}
