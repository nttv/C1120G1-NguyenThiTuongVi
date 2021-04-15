package com.example.controllers;

import com.example.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class LoginController {
    @RequestMapping(value = {"", "/welcome"}, method = RequestMethod.GET)
    public String getWelcomePage(Model model) {
        model.addAttribute("message", "This is welcome page!");
        return "login/welcome";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String adminPage(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "login/admin";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(Model model) {
        return "login/login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutSuccessfulPage() {
        return "login/logout";
    }

    @RequestMapping(value = "/user-info", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {
        // Sau khi user login thanh cong se co principal
        String username = principal.getName();
        System.out.println("Username: " + username);
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "login/user";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
        }
        return "login/403Page";
    }
}
