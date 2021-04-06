package com.example.controllers;

import com.example.models.Category;
import com.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", new Category());
        return "category/list";
    }

    @GetMapping("/save")
    public String save(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("message", "Saved category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", categoryService.findById(id));
        return "category/edit";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam Integer id, RedirectAttributes redirect) {
        categoryService.remove(id);
        redirect.addFlashAttribute("message", "Removed category successfully!");
        return "redirect:/category";
    }

    @GetMapping("/blogs")
    public String view(@RequestParam Integer id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("category", category);
        model.addAttribute("blogs", category.getBlogs());
        return "category/view";
    }
}
