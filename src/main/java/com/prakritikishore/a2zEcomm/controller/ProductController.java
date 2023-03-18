package com.prakritikishore.a2zEcomm.controller;

import com.prakritikishore.a2zEcomm.common.ApiResponse;
import com.prakritikishore.a2zEcomm.dto.ProductDto;
import com.prakritikishore.a2zEcomm.service.CategoryService;
import com.prakritikishore.a2zEcomm.service.ProductService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@SecurityRequirement(name = "Authorization")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto){

        if (!categoryService.isCategory(productDto.getCategoryId())) {
            return new ResponseEntity<>(new ApiResponse(false, "category not found"), HttpStatus.NOT_FOUND);
        }
        productService.createProduct(productDto);

        return new ResponseEntity<>(new ApiResponse(true, "product creation successful"), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductDto>> getAllProducts(){

        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/edit/{product-id}")
    public ResponseEntity<ApiResponse> editProduct(@PathVariable("product-id") Integer productId, @RequestBody ProductDto productDto) throws Exception{
        System.out.print(productId);
        System.out.print(productId.getClass());
        if (!categoryService.isCategory(productDto.getCategoryId())) {
            return new ResponseEntity<>(new ApiResponse(false, "category not found"), HttpStatus.NOT_FOUND);
        }
        productService.editProduct(productId, productDto);

        return new ResponseEntity<>(new ApiResponse(true, "update successful"), HttpStatus.CREATED);
    }

}
