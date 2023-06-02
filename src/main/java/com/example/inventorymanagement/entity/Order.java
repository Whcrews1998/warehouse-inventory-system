package com.example.inventorymanagement.entity;

import com.example.inventorymanagement.embeddable.Vendor;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity(name="purchased_order")
public class Order {
    @Id
    @GeneratedValue
    private Integer id;
    private Date creationDate;
    private Boolean isReceived;
    @Embedded
    private Vendor vendor;
    private double totalPrice;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<OrderInfo> orderInfoList;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getReceived() {
        return isReceived;
    }

    public void setReceived(Boolean received) {
        isReceived = received;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderInfo> getOrderDetailsList() {
        return orderInfoList;
    }

    public void setOrderDetailsList(List<OrderInfo> orderInfoList) {
        this.orderInfoList = orderInfoList;
    }
}
