package day_3_array_and_method.thuc_hanh;

import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size;
        do {
            System.out.print("Nhap so luong phan tu cua mang: ");
            size = sc.nextInt();
        } while (size > 20 || size <= 0);
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.print("Nhap gia tri phan tu thu " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }
        System.out.print("Mang: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = tmp;
        }
        System.out.print("Mang dao nguoc: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
