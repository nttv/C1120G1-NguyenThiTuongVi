package day_3_array_and_method.bai_tap;

import java.util.Scanner;

public class CountCharInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mot chuoi: ");
        String s = sc.nextLine();
        System.out.print("Nhap ky tu: ");
        char c = sc.nextLine().charAt(0);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                count++;
            }
        }
        System.out.println("Chuoi: " + s);
        System.out.println("Ky tu " + c + " xuat hien trong chuoi " + count + " lan");
    }
}
