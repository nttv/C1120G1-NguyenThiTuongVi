package day_4_class_and_object.thuc_hanh;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chieu dai hinh chu nhat: ");
        double width = sc.nextDouble();
        System.out.print("Nhap chieu rong hinh chu nhat: ");
        double height = sc.nextDouble();
        Rectangle rect = new Rectangle(width, height);
        System.out.println(rect.display());
        System.out.println("Dien tich hinh chu nhat: " + rect.getArea());
        System.out.println("Chu vi hinh chu nhat: " + rect.getPerimeter());
    }
}
