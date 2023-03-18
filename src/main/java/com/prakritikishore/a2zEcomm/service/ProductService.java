package com.prakritikishore.a2zEcomm.service;

import com.prakritikishore.a2zEcomm.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void createProduct(ProductDto productDto);

    List<ProductDto> getAllProducts();

    void editProduct(Integer productId, ProductDto productDto) throws Exception;
}
