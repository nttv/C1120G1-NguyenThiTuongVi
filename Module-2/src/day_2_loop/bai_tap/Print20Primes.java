package day_2_loop.bai_tap;

import java.util.Scanner;

public class Print20Primes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong so nguyen to can in ra: ");
        int numbers = sc.nextInt();
        int count = 0;
        int num = 2;
        while (count < numbers) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
                System.out.print(num + " ");
            }
            num++;
        }
    }
}
