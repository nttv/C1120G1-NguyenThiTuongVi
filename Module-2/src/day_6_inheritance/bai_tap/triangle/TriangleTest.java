package day_6_inheritance.bai_tap.triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap do dai canh a cua tam giac: ");
        double a = sc.nextDouble();
        System.out.print("Nhap do dai canh b cua tam giac: ");
        double b = sc.nextDouble();
        System.out.print("Nhap do dai canh c cua tam giac: ");
        double c = sc.nextDouble();
        sc.nextLine();
        System.out.print("Nhap mau sac cua tam giac: ");
        String color = sc.nextLine();

        Triangle triangle = new Triangle(color, a, b, c);
        System.out.println(triangle);
    }
}