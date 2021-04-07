package com.example.controllers;

import com.example.models.Blog;
import com.example.services.BlogService;
import com.example.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    public ModelAndView getHomePage(@PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("blog/index", "blogs", blogService.findAll(pageable));
    }

    @GetMapping("/blog/create")
    public String create(Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.findAll(pageable));
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
    public String edit(@RequestParam int id, Pageable pageable, Model model) {
        model.addAttribute("categories", categoryService.findAll(pageable));
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

    @GetMapping("/blog/search")
    public ModelAndView searchInTitle(@RequestParam String key, @PageableDefault(value = 2) Pageable pageable) {
        return new ModelAndView("blog/index", "blogs", blogService.searchInTitle(key, pageable));
    }
}
