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
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        model.addAttribute("operator", operator);
        if (number2 == 0 && operator.equals("Division")) {
            model.addAttribute("result", "Error divide by 0");
        } else {
            model.addAttribute("result", calculatorService.calculate(number1, number2, operator));
        }
        return "index";
    }
}
