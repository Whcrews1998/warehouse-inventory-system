package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Category;
import com.example.inventorymanagement.model.CategoryDetails;
import com.example.inventorymanagement.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> getAllCategories() {
        List<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("/categories/create-category")
    public ResponseEntity<Category> createNewCategory(@RequestBody CategoryDetails categoryDetails) {
        Category category = categoryDetails.createCategoryEntity();
        categoryService.save(category);
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/categories/create-category-list")
    public ResponseEntity<List<Category>> createNewCategory(@RequestBody List<CategoryDetails> categoryDetailsList) {
        List<Category> categoryList = new ArrayList<>();
        for (CategoryDetails info : categoryDetailsList) {
            categoryList.add(info.createCategoryEntity());
        }

        categoryService.saveAll(categoryList);
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }
}
