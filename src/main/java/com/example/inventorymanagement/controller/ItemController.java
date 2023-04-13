package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Item;
import com.example.inventorymanagement.model.ItemDetails;
import com.example.inventorymanagement.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class ItemController {
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity<Item> addItemToInventory(@RequestBody ItemDetails itemDetails) {
        Item item = itemDetails.createItemEntity();
        itemService.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

}
