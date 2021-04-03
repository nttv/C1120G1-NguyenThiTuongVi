package example.controllers;

import org.example.models.Product;
import org.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String getHomePage(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("products", productList);
        return "index";
    }

    @GetMapping("/product/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("productTypes", productService.getProductTypeList());
        return "create";
    }

    @PostMapping("/product/save")
    public String save(Product product, RedirectAttributes redirect) {
        productService.save(product);
        redirect.addFlashAttribute("message", "Added product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/edit")
    public String edit(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("productTypes", productService.getProductTypeList());
        return "edit";
    }

    @PostMapping("/product/update")
    public String update(Product product, RedirectAttributes redirect) {
        productService.update(product);
        redirect.addFlashAttribute("message", "Updated product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/delete")
    public String delete(@RequestParam int id, RedirectAttributes redirect) {
        productService.remove(productService.findById(id).getId());
        redirect.addFlashAttribute("message", "Removed product successfully!");
        return "redirect:/";
    }

    @GetMapping("/product/view")
    public String view(@RequestParam int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
