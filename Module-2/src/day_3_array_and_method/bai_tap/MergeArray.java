package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array1 = new int[4];
        int[] array2 = new int[5];
        int[] array = new int[array1.length + array2.length];
        String arr1 = "";
        String arr2 = "";
        String arr = "";

        System.out.println("Nhap gia tri mang 1");
        for (int i = 0; i < array1.length; i++) {
            System.out.println("Nhap gia tri phan tu thu " + (i + 1));
            array1[i] = sc.nextInt();
            arr1 += array1[i] + "\t";
            array[i] = array1[i];
            arr += array1[i] + "\t";
        }
        System.out.println("Nhap gia tri mang 2");
        for (int i = 0; i < array2.length; i++) {
            System.out.println("Nhap gia tri phan tu thu " + (i + 1));
            array2[i] = sc.nextInt();
            arr2 += array2[i] + "\t";
            array[i + array1.length] = array2[i];
            arr += array2[i] + "\t";
        }
        System.out.println("Mang 1: " + arr1);
        System.out.println("Mang 2: " + arr2);
        System.out.println("Mang gop: " + arr);
    }
}
