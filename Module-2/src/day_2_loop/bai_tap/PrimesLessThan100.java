package day_2_loop.bai_tap;

import java.util.Scanner;

public class PrimesLessThan100 {
    public static void main(String[] args) {
        int number = 2;
        while (number < 100) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.print(number + " ");
            }
            number++;
        }
    }
}
