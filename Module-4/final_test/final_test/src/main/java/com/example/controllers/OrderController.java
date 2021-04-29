package com.example.controllers;

import com.example.models.Order;
import com.example.models.Product;
import com.example.models.ProductType;
import com.example.services.OrderService;
import com.example.services.ProductService;
import com.example.services.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OrderController {

    @Autowired
    private ProductTypeService productTypeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    @GetMapping("")
    public String showList(@PageableDefault(value = 4) Pageable pageable, Model model) {
        model.addAttribute("orders", orderService.findAll(pageable));
        return "index";
    }

    @GetMapping("{id}/edit")
    public String editOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("productTypes", productTypeService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("order", orderService.findById(id));
        return "edit";
    }

//    @PostMapping("update")
//    public String updateOrder(@Validated @ModelAttribute Order order, BindingResult bindingResult,
//                              Model model, RedirectAttributes redirect) {
//        new Order().validate(order, bindingResult);
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("productTypes", productTypeService.findAll());
//            model.addAttribute("products", productService.findAll());
//            return "edit";
//        } else {
//            orderService.save(order);
//            redirect.addFlashAttribute("message", "Updated order successfully!");
//            return "redirect:/";
//        }
//    }


}
