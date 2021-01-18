package day_10_dsa_stack_and_queue.bai_tap;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeChecking {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        Stack stack = new Stack();
        Queue queue = new LinkedList();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
            queue.add(str.charAt(i));
        }
        while (!stack.isEmpty()) {
            if (!stack.pop().equals(queue.remove())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap mot chuoi de kiem tra: ");
        String str = sc.nextLine();
        if (isPalindrome(str)) {
            System.out.println("\"" + str + "\" la chuoi Palindrome");
        } else {
            System.out.println("\"" + str + "\" khong phai la chuoi Palindrome");
        }
    }
}
