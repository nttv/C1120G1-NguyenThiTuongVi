package com.furamavietnam.controllers;

import com.furamavietnam.models.Customer;
import com.furamavietnam.services.CustomerService;
import com.furamavietnam.services.CustomerTypeService;
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
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

    @GetMapping("")
    public String getCustomerPage(@PageableDefault(value = 4) Pageable pageable, Model model) {
        model.addAttribute("customers", customerService.findAll(pageable));
        return "customer/list";
    }

    @GetMapping("list")
    @ResponseBody
    public Page<Customer> getList(@PageableDefault(value = 4) Pageable pageable, Model model) {
        return customerService.findAll(pageable);
    }

    @GetMapping("create")
    public String addCustomer(Model model) {
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("save")
    public String saveCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Added customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("{id}/edit")
    public String editCustomer(@PathVariable String id, Model model) {
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("update")
    public String updateCustomer(Customer customer, RedirectAttributes redirect) {
        customerService.save(customer);
        redirect.addFlashAttribute("message", "Updated customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("{id}/delete")
    public String deleteCustomer(@PathVariable String id, RedirectAttributes redirect) {
        customerService.delete(id);
        redirect.addFlashAttribute("message", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("search")
    public String deleteCustomer(@RequestParam String key, @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Customer> customerList = customerService.findAllByKey(key, pageable);
        if (customerList.isEmpty()) {
            model.addAttribute("customers", customerService.findAll(pageable));
        } else {
            model.addAttribute("customers", customerList);
        }
        return "customer/list";
    }

}
