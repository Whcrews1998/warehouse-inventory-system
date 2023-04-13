package com.example.inventorymanagement.service;

import com.example.inventorymanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryService extends JpaRepository<Category, Integer> {
}
