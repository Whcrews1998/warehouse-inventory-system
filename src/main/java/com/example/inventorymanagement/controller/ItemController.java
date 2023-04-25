package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Category;
import com.example.inventorymanagement.entity.Item;
import com.example.inventorymanagement.entity.Subcategory;
import com.example.inventorymanagement.model.ItemDetails;
import com.example.inventorymanagement.model.SubcategoryDetails;
import com.example.inventorymanagement.service.CategoryService;
import com.example.inventorymanagement.service.ItemService;
import com.example.inventorymanagement.service.SubcategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ItemController {
    private ItemService itemService;
    private SubcategoryService subcategoryService;
    private CategoryService categoryService;

    public ItemController(ItemService itemService, SubcategoryService subcategoryService, CategoryService categoryService) {
        this.itemService = itemService;
        this.subcategoryService = subcategoryService;
        this.categoryService = categoryService;
    }


    @GetMapping("/items")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> itemList = itemService.findAll();
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @PostMapping("/items/create-item")
    public ResponseEntity<Item> addItemToInventory(@RequestBody ItemDetails itemDetails) {
        Optional<Subcategory> subcategory = subcategoryService.findById(itemDetails.getSubcategoryDetails().getId());
        if (subcategory.isEmpty()) throw new RuntimeException("Subcategory does not exist");

        Item item = itemDetails.createItemEntity();
        item.setSubcategory(subcategory.get());
        itemService.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @PostMapping("/items/create-item-list")
    public ResponseEntity<List<Item>> addItemListToInventory(@RequestBody List<ItemDetails> list) {
        List<Item> itemList = new ArrayList<>();
        List<Subcategory> subcategoryList = subcategoryService.findAll();

        for (ItemDetails info : list) {
            Integer subId = info.getSubcategoryDetails().getId();
            Optional<Subcategory> subcategory = subcategoryList.stream().filter(subcategory1 -> subcategory1.getId().equals(subId)).findFirst();

            if (subcategory.isEmpty()) throw new RuntimeException("Subcategory does not exist");

            Item item = info.createItemEntity();
            item.setSubcategory(subcategory.get());
            itemList.add(item);
        }

        itemService.saveAll(itemList);
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/items/find-by-category/{catId}")
    public ResponseEntity<List<Item>> findItemByCategory(@PathVariable int catId) {
        Optional<Category> category = categoryService.findById(catId);
        if (category.isEmpty()) throw new RuntimeException("Category does not exist!");

        List<Item> itemList = new ArrayList<>();
        for (Subcategory subcategory : category.get().getSubcategoryList()) {
            List<Item> items = itemService.findBySubcategory(subcategory);
            itemList.addAll(items);
        }

        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

    @GetMapping("/items/find-by-subcategory/{subId}")
    public ResponseEntity<List<Item>> findBySubCategory(@PathVariable int subId) {
        Optional<Subcategory> subcategory = subcategoryService.findById(subId);
        if (subcategory.isEmpty()) throw new RuntimeException("Subcategory does not exist!");
        List<Item> itemList = itemService.findBySubcategory(subcategory.get());
        return new ResponseEntity<>(itemList, HttpStatus.OK);
    }

}
