package day_1_introduction_to_java.thuc_hanh;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        boolean check = true;
        if (year % 4 == 0) {
            if (year % 100 == 0 && year % 400 != 0) {
                check = false;
            }
        } else {
            check = false;
        }
        if (check) {
            System.out.println(year + " is a leap year");
        } else {
            System.out.println(year + " is not a leap year");
        }
    }
}
