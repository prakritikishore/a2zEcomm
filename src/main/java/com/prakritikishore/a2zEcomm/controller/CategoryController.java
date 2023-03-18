package com.prakritikishore.a2zEcomm.controller;

import com.prakritikishore.a2zEcomm.common.ApiResponse;
import com.prakritikishore.a2zEcomm.model.Category;
import com.prakritikishore.a2zEcomm.service.CategoryService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category)
    {
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "category creation successful"), HttpStatus.CREATED);
    }

    @GetMapping("/{category-id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable("category-id") Integer categoryId){
        return new ResponseEntity<>(categoryService.getCategoryById(categoryId), HttpStatus.OK);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Category>> getAllCategories(){
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PostMapping("/edit/{category-id}")
    public ResponseEntity<ApiResponse> editCategory(@PathVariable("category-id") Integer categoryId, @RequestBody Category category) {
        if (!categoryService.isCategory(categoryId)) {
            return new ResponseEntity<>(new ApiResponse(false, "category not found"), HttpStatus.NOT_FOUND);
        }
            categoryService.editCategory(categoryId, category);
            return new ResponseEntity<>(new ApiResponse(true, "update successful"), HttpStatus.OK);
    }
}
