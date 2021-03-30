package org.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.example.services.CalculatorService;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/")
    public String getCalculator() {
        return "index";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam double number1, @RequestParam double number2,
                            @RequestParam String operator, Model model) {
        double result = calculatorService.calculate(number1, number2, operator);
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("operator", operator);
        model.addAttribute("result", result);
        return "index";
    }
}
