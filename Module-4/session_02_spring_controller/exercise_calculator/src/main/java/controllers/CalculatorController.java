package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import services.CalculatorService;

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
        try {
            model.addAttribute("result", calculatorService.calculate(number1, number2, operator));
        } catch (ArithmeticException e) {
            model.addAttribute("result", e.getMessage());
        }
        return "index";
    }
}
