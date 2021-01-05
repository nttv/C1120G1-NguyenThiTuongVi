package day_2_loop.thuc_hanh;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.print("Menu\n" +
                    "1. Draw the triangle\n" +
                    "2. Draw the square\n" +
                    "3. Draw the rectangle\n" +
                    "0. Exit\n" +
                    "Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Draw the triangle");
                    System.out.println("*");
                    System.out.println("***");
                    System.out.println("*****");
                    System.out.println("*******");
                    System.out.println("*********");
                    System.out.println("***********");
                    break;
                case 2:
                    System.out.println("Draw the square");
                    System.out.println("* * * * * * * *");
                    System.out.println("* * * * * * * *");
                    System.out.println("* * * * * * * *");
                    System.out.println("* * * * * * * *");
                    System.out.println("* * * * * * * *");
                    System.out.println("* * * * * * * *");
                    break;
                case 3:
                    System.out.println("Draw the rectangle");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    System.out.println("* * * * * *");
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Wrong choice!");
            }
        } while (choice != 0);
    }
}
