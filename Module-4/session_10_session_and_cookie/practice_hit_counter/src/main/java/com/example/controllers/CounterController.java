package com.example.controllers;

import com.example.models.Counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"counter","counter2"})
public class CounterController {

    /* add Counter in model attribute */
    @ModelAttribute("counter")
    public Counter setUpCounter() {
        return new Counter();
    }

    @ModelAttribute("counter2")
    public Counter setUpCounter2() {
        return new Counter(10);
    }

    @GetMapping("/")
    public String get(@ModelAttribute("counter") Counter counter,@ModelAttribute("counter2") Counter counter2) {
        counter.increment();
        counter2.decrement();
        return "index";
    }
}
