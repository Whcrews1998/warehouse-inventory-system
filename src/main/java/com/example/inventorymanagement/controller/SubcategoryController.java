package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Subcategory;
import com.example.inventorymanagement.model.SubcategoryDetails;
import com.example.inventorymanagement.service.SubcategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Controller
public class SubcategoryController {
    private SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @GetMapping("/subcategories")
    public ResponseEntity<List<Subcategory>> getAllSubcategories() {
        List<Subcategory> subcategoryList = subcategoryService.findAll();
        return new ResponseEntity<>(subcategoryList, HttpStatus.OK);
    }

    @PostMapping("/subcategories")
    public ResponseEntity<Subcategory> createNewSubcategory(@RequestBody SubcategoryDetails subcategoryDetails) {
        Subcategory subcategory = subcategoryDetails.createSubcategoryEntity();
        subcategoryService.save(subcategory);
        return new ResponseEntity<Subcategory>(subcategory, HttpStatus.OK);
    }

}
