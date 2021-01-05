package day_2_loop.thuc_hanh;

import java.util.Scanner;

public class Interest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong tien cho vay: ");
        double money = sc.nextDouble();
        System.out.print("Nhap ti le lai suat % nam: ");
        double interestRate = sc.nextDouble();
        System.out.print("Nhap so thang cho vay: ");
        int month = sc.nextInt();
        double interest = 0;
        for (int i = 0; i < month; i++) {
            interest += money * (interestRate / 100) / 12 * month;
        }
        System.out.println("Total interest: " + interest);
    }
}
