package com.furamavietnam.controllers;

import com.furamavietnam.models.AppUser;
import com.furamavietnam.services.user.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@SessionAttributes("appUser")
public class MainController {

    @Autowired
    private AppUserService appUserService;

    @ModelAttribute("appUser")
    public AppUser getUser(Principal principal) {
        if (principal != null) {
            return appUserService.findByUsername(principal.getName());
        }
        return new AppUser();
    }

    @GetMapping("")
    public String showHomePage(Model model) {
        return "index";
    }

    @GetMapping("/index")
    public String showHomeLogined(@ModelAttribute("appUser") AppUser appUser, Principal principal, Model model) {
        String username = "";
        if (principal != null) {
            username = principal.getName();
            model.addAttribute("appUser", appUserService.findByUsername(username));
        }
        return "index";
    }

}
