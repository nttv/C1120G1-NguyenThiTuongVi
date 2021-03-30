package org.example.services.impl;

import org.example.services.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public double calculate(double number1, double number2, String operator) {
        double result = 0;
        switch (operator) {
            case "Addition":
                result = number1 + number2;
                break;
            case "Subtraction":
                result = number1 - number2;
                break;
            case "Multiplication":
                result = number1 * number2;
                break;
            case "Division":
                result = number1 / number2;
                break;
        }
        return result;
    }
}
