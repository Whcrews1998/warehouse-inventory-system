package com.example.inventorymanagement.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name="sub_category")
public class Subcategory {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Subcategory() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
