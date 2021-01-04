package day_1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class Operator {
    public static void main(String[] args) {
        float width;
        float height;
        float area;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width = ");
        width = scanner.nextFloat();
        System.out.print("Enter height = ");
        height = scanner.nextFloat();
        area = width * height;
        System.out.println("Rectangle area = " + area);
    }
}
