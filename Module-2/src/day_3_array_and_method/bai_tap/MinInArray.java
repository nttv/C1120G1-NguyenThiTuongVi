package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class MinInArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so phan tu cua mang: ");
        int size = sc.nextInt();

        int[] array = new int[size];
        String arr = "";

        for (int i = 0; i < size; i++) {
            System.out.println("Nhap gia tri phan tu thu " + (i + 1));
            array[i] = sc.nextInt();
            arr += array[i] + "\t";
        }
        System.out.println("Mang: " + arr);
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Gia tri nho nhat trong mang: " + min);
    }
}