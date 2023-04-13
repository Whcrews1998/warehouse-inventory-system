package com.example.inventorymanagement.service;

import com.example.inventorymanagement.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemService extends JpaRepository<Item, Integer> {

}
