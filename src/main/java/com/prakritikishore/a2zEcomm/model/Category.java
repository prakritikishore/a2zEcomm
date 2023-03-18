package com.prakritikishore.a2zEcomm.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Integer id;
    @Column(name = "category_name")
    private String name;
    @Column(name = "category_description")
    private String description;
    @Column(name = "category_image_url")
    private String imageUrl;
}
