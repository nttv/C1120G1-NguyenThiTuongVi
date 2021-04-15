package com.example.services;

import com.example.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);

    List<Category> findAll();

    Category findById(int id);

    void save(Category category);

    void remove(int id);
}
