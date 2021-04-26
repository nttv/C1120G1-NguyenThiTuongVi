package com.furamavietnam.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.security.Principal;

@Controller
@SessionAttributes("user")
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @GetMapping("403")
    public String accessDenied(Principal principal) {
        return "403";
    }

    @GetMapping("logout")
    public String logout() {
        return "redirect:/";
    }

}
