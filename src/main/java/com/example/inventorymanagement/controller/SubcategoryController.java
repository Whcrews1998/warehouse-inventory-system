package com.example.inventorymanagement.controller;

import com.example.inventorymanagement.entity.Subcategory;
import com.example.inventorymanagement.model.SubcategoryDetails;
import com.example.inventorymanagement.service.SubcategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class SubcategoryController {
    private SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping("/subcategories")
    public ResponseEntity<Subcategory> createNewSubcategory(@RequestBody SubcategoryDetails subcategoryDetails) {
        Subcategory subcategory = subcategoryDetails.createSubcategoryEntity();
        subcategoryService.save(subcategory);
        return new ResponseEntity<Subcategory>(subcategory, HttpStatus.OK);
    }

}
