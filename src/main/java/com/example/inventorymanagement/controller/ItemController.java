package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Item;
import com.example.inventorymanagement.entity.Subcategory;
import com.example.inventorymanagement.model.ItemDetails;
import com.example.inventorymanagement.model.SubcategoryDetails;
import com.example.inventorymanagement.service.ItemService;
import com.example.inventorymanagement.service.SubcategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class ItemController {
    private ItemService itemService;
    private SubcategoryService subcategoryService;

    public ItemController(ItemService itemService, SubcategoryService subcategoryService) {
        this.itemService = itemService;
        this.subcategoryService = subcategoryService;
    }

    @PostMapping("/items")
    public ResponseEntity<Item> addItemToInventory(@RequestBody ItemDetails itemDetails) {
        Optional<Subcategory> subcategory = subcategoryService.findById(itemDetails.getSubcategoryDetails().getId());
        if (subcategory.isEmpty()) throw new RuntimeException("Subcategory does not exist");

        Item item = itemDetails.createItemEntity();
        item.setSubcategory(subcategory.get());
        itemService.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
