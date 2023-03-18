package com.prakritikishore.a2zEcomm.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private Integer id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;
    private Integer categoryId;
}
