package day_2_loop.thuc_hanh;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        a = Math.abs(a);
        b = Math.abs(b);
        int gcd = 1;
        if (a == 0 && b == 0) {
            System.out.println("No greatest common divisor");
        } else {
            if (a == 0) {
                gcd = b;
            } else if (b == 0) {
                gcd = a;
            } else {
                while (a != b) {
                    if (a > b)
                        a = a - b;
                    else
                        b = b - a;
                }
                gcd = a;
            }
            System.out.println("Greatest common factor: " + gcd);
        }
    }
}
