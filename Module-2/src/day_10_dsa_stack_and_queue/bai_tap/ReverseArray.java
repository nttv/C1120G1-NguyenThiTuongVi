package day_10_dsa_stack_and_queue.bai_tap;

import java.util.Stack;

public class ReverseArray {
    public static int[] reverseArrayOfIntegers(int[] array) {
        Stack<Integer> stack = new Stack<>();
        for (int i : array) {
            stack.push(i);
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = stack.pop();
        }
        return array;
    }

    public static String reverseArrayOfStrings(String string) {
        String[] array = string.split(" ");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String str = "Hello 2021 C1120G1";
        System.out.println(reverseArrayOfStrings(str));
        for (int i : reverseArrayOfIntegers(array)) {
            System.out.print(i + " ");
        }
    }
}
