package com.prakritikishore.a2zEcomm.service;

import com.prakritikishore.a2zEcomm.dto.ProductDto;
import com.prakritikishore.a2zEcomm.model.Product;
import com.prakritikishore.a2zEcomm.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements  ProductService{

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryService categoryService;
    @Override
    public void createProduct(ProductDto productDto) {
        Product product = Product.builder().name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImageUrl())
                .categoryId(categoryService.getCategoryById(productDto.getCategoryId()))
                .build();
        productRepository.save(product);
    }

    private ProductDto toDto(Product product){
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .categoryId(product.getCategoryId().getId())
                .build();
    }

    @Override
    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> toDto(product)).collect(Collectors.toList());
    }

    @Override
    public void editProduct(Integer productId, ProductDto productDto) throws Exception {
        Product product = productRepository.findById(productId).get();
        if(product == null) {
            throw new Exception("product not present");
        }
        Product updateProduct = product.builder()
                .id(product.getId())
                .name(productDto.getName())
                .description(productDto.getDescription())
                .price(productDto.getPrice())
                .imageUrl(productDto.getImageUrl())
                .categoryId(product.getCategoryId())
                .build();
        productRepository.save(updateProduct);
    }
}
