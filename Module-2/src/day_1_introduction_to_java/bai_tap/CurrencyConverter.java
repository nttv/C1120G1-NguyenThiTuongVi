package day_1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        int rate = 23000;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter USD: ");
        int usd = scanner.nextInt();
        int vnd = rate * usd;
        System.out.println(usd + "USD = " + vnd + "VND");
    }
}
