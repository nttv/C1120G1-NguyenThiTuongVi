package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class DeleteElement {
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

        System.out.println("Nhap gia tri muon xoa: ");
        int value = sc.nextInt();

        for (int i = size - 1; i >= 0; i--) {
            if (array[i] == value) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = 0;
            }
        }
        arr = "";
        for (int i : array) {
            arr += i + "\t";
        }
        System.out.println("Mang sau khi xoa: " + arr);
    }
}
