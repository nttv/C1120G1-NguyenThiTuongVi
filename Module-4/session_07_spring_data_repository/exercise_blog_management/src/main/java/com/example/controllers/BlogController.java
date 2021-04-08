package com.example.controllers;

import com.example.models.Blog;
import com.example.services.BlogService;
import com.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping({"", "/blog"})
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public String listBlogs(@RequestParam Optional<String> key, @RequestParam Optional<String> order,
                            @PageableDefault(value = 2) Pageable pageable, Model model) {
        Page<Blog> blogs;
        if (order.isPresent()) {
            if (order.get().equals("asc")) {
                pageable = PageRequest.of(pageable.getPageNumber(), 2, Sort.by("title").ascending());
            } else {
                pageable = PageRequest.of(pageable.getPageNumber(), 2, Sort.by("title").descending());
            }
            model.addAttribute("order", order.get());
        }
        if (key.isPresent() && !key.get().trim().equals("")) {
            model.addAttribute("key", key.get());
            blogs = blogService.searchInTitle(key.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        model.addAttribute("blogs", blogs);
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

//    @GetMapping("/search")
//    public String searchInTitle(@RequestParam String key, @PageableDefault(value = 2) Pageable pageable, Model model) {
//        if (key.trim().equals("")) {
//            model.addAttribute("key", key);
//            model.addAttribute("blogs", blogService.searchInTitle(key, pageable));
//            return "blog/index";
//        } else {
//            return "redirect:/";
//        }
//    }
}
