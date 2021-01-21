package day_12_searching_algorithms.bai_tap;

import java.util.LinkedList;
import java.util.Scanner;

public class ContinuousString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap chuoi: ");
        String string = sc.nextLine();
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < string.length(); i++) {
            LinkedList<Character> substring = new LinkedList<>();
            substring.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > substring.getLast()) {
                    substring.add(string.charAt(j));
                } else {
                    break;
                }
            }
            if (substring.size() > max.size()) {
                max.clear();
                max = substring;
            }
        }
        for (Character c : max) {
            System.out.print(c);
        }
    }
}
