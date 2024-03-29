package com.example.controllers;

import com.example.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes("user")
public class LoginController {

    /*add user in model attribute*/
    @ModelAttribute("user")
    public User setUpUserForm() {
        return new User();
    }

    @RequestMapping("")
    public String Index(@CookieValue(value = "setUser", defaultValue = "") String setUser, Model model) {
        Cookie cookie = new Cookie("setUser", setUser);
        model.addAttribute("cookie", cookie);
        return "login";
    }

    @PostMapping("/login")
    public String doLogin(@ModelAttribute("user") User user, Model model, @CookieValue(value = "setUser", defaultValue = "") String setUser,
                          HttpServletResponse response, HttpServletRequest request) {
        //implement business logic
        if (user.getEmail().equals("admin@gmail.com") && user.getPassword().equals("12345")) {
            setUser = user.getEmail();

            // create cookie and set it in response
            Cookie cookie = new Cookie("setUser", setUser);
            cookie.setMaxAge(24 * 60 * 60);
            response.addCookie(cookie);
            model.addAttribute("cookie", cookie);
            model.addAttribute("message", "Login success. Welcome ");

//            //get all cookies
//            Cookie[] cookies = request.getCookies();
//            //iterate each cookie
//            for (Cookie ck : cookies) {
//                //display only the cookie with the name 'setUser'
//                if (ck.getName().equals("setUser")) {
//                    model.addAttribute("cookie", ck);
//                    break;
//                } else {
//                    ck.setValue("");
//                    model.addAttribute("cookie", ck);
//                    break;
//                }
//            }
        } else {
            user.setEmail("");
            Cookie cookie = new Cookie("setUser", setUser);
            model.addAttribute("cookie", cookie);
            model.addAttribute("message", "Login failed. Try again.");
        }
        return "login";
    }
}
