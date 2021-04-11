package com.example.controllers;

import com.example.models.Cart;
import com.example.models.Product;
import com.example.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart setUpCart(@CookieValue(name = "cartCookie", defaultValue = "") String cartCookieValue) {
        return readCartCookie(cartCookieValue);
    }

    @GetMapping
    public String listProducts(@CookieValue(name = "cartCookie", defaultValue = "") String cartCookieValue,
                               @ModelAttribute("cart") Cart cart, Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping("/detail")
    public String viewDetail(@RequestParam Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }

    @PostMapping("/detail")
    public String addToCart(@ModelAttribute("cart") Cart cart,
                            @CookieValue(name = "cartCookie", defaultValue = "") String cartCookieValue,
                            Product product, Model model,
                            HttpServletResponse response) {
        cart.addToCart(product);

        Cookie cookie = new Cookie("cartCookie", createCartString(cart));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        model.addAttribute("product", product);
        model.addAttribute("message", "Added product to cart successfully!");
        return "detail";
    }

    @GetMapping("/cart")
    public String viewCart(@ModelAttribute("cart") Cart cart) {
        return "cart";
    }

    @PostMapping("/cart")
    public String updateCart(@ModelAttribute(name = "cart") Cart cart,
                             @RequestParam(name = "changeId") Optional<Integer> changeId,
                             @RequestParam(name = "changeValue") Optional<Integer> changeValue,
                             @RequestParam(name = "deleteId") Optional<Integer> deleteId,
                             @CookieValue(name = "cartCookie", defaultValue = "") String cartCookieValue,
                             HttpServletResponse response) {
        if (changeId.isPresent() && changeValue.isPresent()) {
            Product product = productService.findById(changeId.get());
            cart.changeQuantity(product, changeValue.get());
        } else if (deleteId.isPresent()) {
            Product product = productService.findById(deleteId.get());
            cart.removeProduct(product);
        }

        Cookie cookie = new Cookie("cartCookie", createCartString(cart));
        cookie.setMaxAge(24 * 60 * 60);
        response.addCookie(cookie);

        return "cart";
    }

    public String createCartString(Cart cart) {
        Set<Map.Entry<Product, Integer>> products = cart.getProducts().entrySet();
        StringBuilder cartStr = new StringBuilder();
        for (Map.Entry<Product, Integer> product : products) {
            cartStr.append("-").append(product.getKey().getId()).append("-").append(product.getValue());
        }
        cartStr.deleteCharAt(0);
        return cartStr.toString();
    }

    public Cart readCartCookie(String cookieValueStr) {
        Cart cart = new Cart();
        if (!cookieValueStr.equals("")) {
            Map<Product, Integer> products = new HashMap<>();
            String[] cookieValue = cookieValueStr.split("-");
            for (int i = 0; i < cookieValue.length; i += 2) {
                Product product = productService.findById(Integer.parseInt(cookieValue[i]));
                if (product != null) {
                    products.put(product, Integer.parseInt(cookieValue[i + 1]));
                }
            }
            cart.setProducts(products);
        }
        return cart;
    }
}
