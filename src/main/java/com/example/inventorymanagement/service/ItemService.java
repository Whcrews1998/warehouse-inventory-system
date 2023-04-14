package com.example.inventorymanagement.service;

import com.example.inventorymanagement.entity.Item;
import com.example.inventorymanagement.entity.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemService extends JpaRepository<Item, Integer> {
    List<Item> findBySubcategory(Subcategory subcategory);
}
