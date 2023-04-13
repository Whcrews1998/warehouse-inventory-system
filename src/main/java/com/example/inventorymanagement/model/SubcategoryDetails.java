package com.example.inventorymanagement.model;

import com.example.inventorymanagement.entity.Subcategory;

public class SubcategoryDetails {
    private Integer id;
    private String name;




    // Methods
    public Subcategory createSubcategoryEntity() {
        Subcategory subcategory = new Subcategory();
        if (this.id != null) subcategory.setId(this.id);
        subcategory.setName(this.name);
        return subcategory;
    }

    // Getter Setters Constructor
    public SubcategoryDetails() {
    }

    public SubcategoryDetails(Integer id, String name) {
        this.id = id;
        this.name = name;
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
