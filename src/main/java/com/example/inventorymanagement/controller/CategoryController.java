package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Category;
import com.example.inventorymanagement.model.CategoryDetails;
import com.example.inventorymanagement.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/categories")
    public ResponseEntity<Category> createNewCategory(@RequestBody CategoryDetails categoryDetails) {
        Category category = categoryDetails.createCategoryEntity();
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
