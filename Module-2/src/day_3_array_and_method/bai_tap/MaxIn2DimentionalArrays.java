package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class MaxIn2DimentionalArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so dong cua ma tran: ");
        int row = sc.nextInt();
        System.out.print("Nhap so cot cua ma tran: ");
        int column = sc.nextInt();

        int[][] matrix = new int[row][column];
        String arr = "";
        int max = 0, x = 0, y = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print("Nhap gia tri phan tu matrix[" + i + "][" + j + "]: ");
                matrix[i][j] = sc.nextInt();
                arr += matrix[i][j] + " ";
                if (i == 0 && j == 0) {
                    max = matrix[i][j];
                    x = y = 0;
                } else if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    x = i;
                    y = j;
                }
            }
            arr += "\n";
        }
        System.out.println("Matrix:\n" + arr);
        System.out.println("Gia tri max trong ma tran la " + max + " o vi tri dong " + x + " cot " + y);
    }
}
