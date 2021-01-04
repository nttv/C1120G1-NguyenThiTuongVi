package day_1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Bmi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your weight (kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter your height (m): ");
        double height = scanner.nextDouble();
        double bmi = weight / Math.pow(height, 2);
        String result;
        if (bmi < 18.5) {
            result = "underweight";
        } else if (bmi < 25) {
            result = "normal";
        } else if (bmi < 30) {
            result = "overweight";
        } else {
            result = "obese";
        }
        System.out.printf("BMI = %.2f%s", bmi, ". You are " + result);
    }
}
