package com.example.services;

import com.example.models.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}
