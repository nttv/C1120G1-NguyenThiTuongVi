package com.furamavietnam.controllers;

import com.furamavietnam.models.Customer;
import com.furamavietnam.services.customer.CustomerService;
import com.furamavietnam.services.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@SessionAttributes("appUser")
@RequestMapping("customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerTypeService customerTypeService;

//    @GetMapping("")
//    public String getCustomerPage(@PageableDefault(value = 4) Pageable pageable, Model model) {
//        model.addAttribute("customers", customerService.findAll(pageable));
//        return "customer/list";
//    }

    @GetMapping("")
    public String getList(@RequestParam Optional<String> key, @PageableDefault(value = 4) Pageable pageable, Model model) {
        Page<Customer> customers;
        if (key.isPresent() && !key.get().trim().equals("")) {
            model.addAttribute("key", key.get());
            customers = customerService.findAllByKey(key.get(), pageable);
        } else {
            customers = customerService.findAll(pageable);
        }
        model.addAttribute("customers", customers);
        return "customer/list";
    }

    @GetMapping("create")
    public String addCustomer(Model model) {
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("customer", new Customer());
        return "customer/create";
    }

    @PostMapping("save")
    public String saveCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult,
                               Model model, RedirectAttributes redirect) {
        new Customer().validate(customer, bindingResult);
        customerService.validateExistingId(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        } else {
            customerService.save(customer);
            redirect.addFlashAttribute("message", "Added customer successfully!");
            return "redirect:/customer";
        }
    }

    @GetMapping("{id}/edit")
    public String editCustomer(@PathVariable String id, Model model) {
        model.addAttribute("customerTypes", customerTypeService.findAll());
        model.addAttribute("customer", customerService.findById(id));
        return "customer/edit";
    }

    @PostMapping("update")
    public String updateCustomer(@Validated @ModelAttribute Customer customer, BindingResult bindingResult,
                                 Model model, RedirectAttributes redirect) {
        new Customer().validate(customer, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("customerTypes", customerTypeService.findAll());
            return "customer/create";
        } else {
            customerService.save(customer);
            redirect.addFlashAttribute("message", "Updated customer successfully!");
            return "redirect:/customer";
        }
    }

    @GetMapping("{id}/delete")
    public String deleteCustomer(@PathVariable String id, RedirectAttributes redirect) {
        customerService.delete(id);
        redirect.addFlashAttribute("message", "Removed customer successfully!");
        return "redirect:/customer";
    }

    @GetMapping("{id}")
    public String viewCustomer(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.findById(id));
        return "customer/view";
    }

//    @GetMapping("search")
//    public String deleteCustomer(@RequestParam String key, @PageableDefault(value = 4) Pageable pageable, Model model) {
//        Page<Customer> customerList = customerService.findAllByKey(key, pageable);
//        if (customerList.isEmpty()) {
//            model.addAttribute("customers", customerService.findAll(pageable));
//        } else {
//            model.addAttribute("key")
//            model.addAttribute("customers", customerList);
//        }
//        return "customer/list";
//    }

}
