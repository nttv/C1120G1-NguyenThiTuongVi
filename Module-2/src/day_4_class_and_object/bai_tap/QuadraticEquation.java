package day_4_class_and_object.bai_tap;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    public double getRoot1() {
        if (getDiscriminant() >= 0) {
            return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        }
        return 0;
    }

    public double getRoot2() {
        if (getDiscriminant() >= 0) {
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("He phuong trinh a*x2 + b*x + c = 0");
        System.out.print("Nhap he so a: ");
        double a = sc.nextDouble();
        System.out.print("Nhap he so b: ");
        double b = sc.nextDouble();
        System.out.print("Nhap he so c: ");
        double c = sc.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        if (equation.getDiscriminant() > 0) {
            System.out.println("The equation has two roots " + equation.getRoot1() + " and " + equation.getRoot2());
        } else if (equation.getDiscriminant() == 0) {
            System.out.println("The equation has one root" + equation.getRoot1());
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}
