package com.example.repositories;

import com.example.models.Blog;
import com.example.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByTitleContaining(String title, Pageable pageable);

    Page<Blog> findByCategory(Category category, Pageable pageable);

    Page<Blog> findByOrderByTitleDesc(Pageable pageable);
}
