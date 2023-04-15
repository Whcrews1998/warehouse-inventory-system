package com.example.inventorymanagement.entity;

import com.example.inventorymanagement.embeddable.Vendor;

import java.util.Date;

public class Order {
    private Integer id;
    private Date creationDate;
    private Boolean isReceived;
    private Vendor vendor;
    private double totalPrice;

}
