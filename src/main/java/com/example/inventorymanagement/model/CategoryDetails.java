package com.example.inventorymanagement.model;

import com.example.inventorymanagement.entity.Category;
import com.example.inventorymanagement.entity.Subcategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryDetails {
    public Integer id;
    public String name;
    public List<SubcategoryDetails> subcategoryList;


    public Category createCategoryEntity() {
        Category category = new Category();

        category.setId(this.id);
        category.setName(this.name);
        for (SubcategoryDetails info : subcategoryList) {
            Subcategory subcategory = info.createSubcategoryEntity();
            category.getSubcategoryList().add(subcategory);
        }

        return category;
    }


    public CategoryDetails() {
        this.subcategoryList = new ArrayList<SubcategoryDetails>();
    }

    public CategoryDetails(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.subcategoryList = new ArrayList<SubcategoryDetails>();
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

    public List<SubcategoryDetails> getSubcategoryList() {
        return subcategoryList;
    }

    public void setSubcategoryList(List<SubcategoryDetails> subcategoryList) {
        this.subcategoryList = subcategoryList;
    }
}
