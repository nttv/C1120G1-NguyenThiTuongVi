package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class InsertElement {
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

        System.out.println("Nhap gia tri muon chen: ");
        int value = sc.nextInt();
        System.out.println("Nhap vi tri muon chen (0 - " + array.length + ": ");
        int index = sc.nextInt();

        int[] temp = new int[size + 1];
        for (int i = 0; i < index; i++) {
            temp[i] = array[i];
        }
        temp[index] = value;
        for (int i = index + 1; i < temp.length; i++) {
            temp[i] = array[i - 1];
        }
        array = temp;
        temp = null;

        arr = "";
        for (int i : array) {
            arr += i + "\t";
        }
        System.out.println("Mang sau khi chen: " + arr);
    }
}