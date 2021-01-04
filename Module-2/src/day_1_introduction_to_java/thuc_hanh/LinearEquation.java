package day_1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LinearEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = 0', please enter constants:");
        System.out.print("a = ");
        float a = scanner.nextFloat();
        System.out.print("b = ");
        float b = scanner.nextFloat();
        if (a == 0) {
            if (b == 0) {
                System.out.println("He phuong trinh co vo so nghiem");
            } else {
                System.out.println("He phuong trinh vo nghiem");
            }
        } else {
            float x = -b / a;
            System.out.println("He phuong trinh co nghiem x = " + x);
        }
    }
}
