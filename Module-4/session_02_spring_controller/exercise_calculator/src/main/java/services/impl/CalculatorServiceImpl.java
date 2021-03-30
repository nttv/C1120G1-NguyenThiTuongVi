package services.impl;

import services.CalculatorService;
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
                if (number2 != 0) {
                    result = number1 / number2;
                } else {
                    throw new ArithmeticException("Error divide by 0");
                }
        }
        return result;
    }
}
