package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class SumElementOfColumn {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dong cua ma tran: ");
        int row = sc.nextInt();
        System.out.print("Nhap so cot cua ma tran: ");
        int column = sc.nextInt();
        int[][] array = new int[row][column];
        String arr = "";

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Nhap gia tri phan tu matrix[" + i + "][" + j + "]: ");
                array[i][j] = sc.nextInt();
                arr += array[i][j] + " ";
            }
            arr += "\n";
        }
        System.out.print("Nhap vi tri cot muon tinh tong (0-" + (column - 1) + "): ");
        int colDelete = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < row; i++) {
            sum += array[i][colDelete];
        }
        System.out.println("Mang 2 chieu:\n" + arr);
        System.out.println("Tong cac phan tu cot " + colDelete + " là " + sum);
    }
}
