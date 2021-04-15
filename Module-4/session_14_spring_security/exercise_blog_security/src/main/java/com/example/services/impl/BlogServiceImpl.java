package com.example.services.impl;

import com.example.models.Blog;
import com.example.models.Category;
import com.example.repositories.BlogRepository;
import com.example.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Blog blog) {
        if (findById(blog.getId()) == null) {
            blog.setAuthor("Admin");
            blog.setDate(new Date(new java.util.Date().getTime()));
        }
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchInTitle(String title, Pageable pageable) {
        return blogRepository.findByTitleContaining(title, pageable);
    }

    @Override
    public Page<Blog> findByCategory(Category category, Pageable pageable) {
        return blogRepository.findByCategory(category, pageable);
    }

    @Override
    public Page<Blog> sortByTitleDesc(Pageable pageable) {
        return blogRepository.findByOrderByTitleDesc(pageable);
    }
}
