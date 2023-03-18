package com.prakritikishore.a2zEcomm.service;

import com.prakritikishore.a2zEcomm.model.Category;
import com.prakritikishore.a2zEcomm.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryRepository categoryRepository;
    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategories() {
       return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        return categoryRepository.findById(categoryId).get();

    }

    @Override
    public boolean isCategory(Integer categoryId) {
        return categoryRepository.existsById(categoryId);

    }

    @Override
    public void editCategory(Integer categoryId, Category category) {
        Category categoryDAO = categoryRepository.findById(categoryId).get();
        categoryDAO.setName(category.getName());
        categoryDAO.setDescription(category.getDescription());
        categoryDAO.setImageUrl(category.getImageUrl());
        categoryRepository.save(categoryDAO);
    }
}
