package com.example.inventorymanagement.service;

import com.example.inventorymanagement.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubcategoryService extends JpaRepository<Subcategory, Integer> {
}
