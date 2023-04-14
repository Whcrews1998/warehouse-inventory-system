package com.example.inventorymanagement.service;

import com.example.inventorymanagement.entity.Category;
import com.example.inventorymanagement.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubcategoryService extends JpaRepository<Subcategory, Integer> {
    public List<Subcategory> findByCategory(Category category);
}
