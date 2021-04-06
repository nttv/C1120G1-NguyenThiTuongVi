package com.example.controllers;

import com.example.models.Blog;
import com.example.services.BlogService;
import com.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String getHomePage(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogs", blogList);
        return "blog/index";
    }

    @GetMapping("/blog/create")
    public String create(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", new Blog());
        return "blog/create";
    }

    @PostMapping("/blog/save")
    public String save(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Added blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/blog/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "blog/edit";
    }

    @PostMapping("/blog/update")
    public String update(Blog blog, RedirectAttributes redirect) {
        blogService.save(blog);
        redirect.addFlashAttribute("message", "Updated blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/blog/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        blogService.remove(id);
        redirect.addFlashAttribute("message", "Removed blog successfully!");
        return "redirect:/";
    }

    @GetMapping("/blog/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog/view";
    }
}
