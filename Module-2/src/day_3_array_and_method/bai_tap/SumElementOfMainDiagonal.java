package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class SumElementOfMainDiagonal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dong (cot) cua ma tran vuong: ");
        int length = sc.nextInt();
        int[][] array = new int[length][length];
        String arr = "";
        int sum = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                System.out.print("Nhap gia tri phan tu matrix[" + i + "][" + j + "]: ");
                array[i][j] = sc.nextInt();
                arr += array[i][j] + " ";
            }
            arr += "\n";
        }

        for (int i = 0; i < length; i++) {
            sum += array[i][i];
        }
        System.out.println("Mang 2 chieu:\n" + arr);
        System.out.println("Tong cac phan tu cua duong cheo chinh là " + sum);
    }
}
