package com.example.services;

import com.example.models.Blog;
import com.example.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void remove(int id);

    Page<Blog> searchInTitle(String title, Pageable pageable);

    Page<Blog> findByCategory(Category category, Pageable pageable);

    Page<Blog> sortByTitleDesc(Pageable pageable);
}
