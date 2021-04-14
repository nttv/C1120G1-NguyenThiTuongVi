package com.example.controllers;

import com.example.models.Blog;
import com.example.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("")
    public ResponseEntity<List<Blog>> listBlog() {
        List<Blog> blogList = blogService.findAll();
        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> view(@PathVariable("id") int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody Blog blog) {
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @RequestBody Blog blog) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setId(id);
        blogService.save(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Blog currentBlog = blogService.findById(id);
        if (currentBlog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
