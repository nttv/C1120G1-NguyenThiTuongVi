package com.example.controllers;

import com.example.models.Blog;
import com.example.services.BlogService;
import com.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    @ResponseBody
    public List<Blog> getBlogList(@PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> blogs = blogService.findAll(pageable);
        return blogs.getContent();
    }

    @GetMapping("")
    public String showBlogList() {
        return "blog/index";
    }

    @GetMapping("/create")
    public String create(Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.findAll(pageable));
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Added blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.findAll(pageable));
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Updated blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("message", "Removed blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }

    @GetMapping("/search")
    @ResponseBody
    public List<Blog> searchInTitle(@RequestParam String key, @PageableDefault(value = 2) Pageable pageable) {
        Page<Blog> blogs;
        if (key.trim().equals("")) {
            blogs = blogService.findAll(pageable);
        } else {
            blogs = blogService.searchInTitle(key, pageable);
        }
        return blogs.getContent();
    }
}
