package com.prakritikishore.a2zEcomm.service;

import com.prakritikishore.a2zEcomm.model.Category;

import java.util.List;

public interface CategoryService {

    void createCategory(Category category);

    List<Category> getAllCategories();

    Category getCategoryById(Integer categoryId);

    void editCategory(Integer categoryId, Category category);

    boolean isCategory(Integer categoryId);
}
