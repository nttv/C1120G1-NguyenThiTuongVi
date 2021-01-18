package day_10_dsa_stack_and_queue.bai_tap;

import java.util.*;

public class BracketsChecking {
    public static boolean checkBrackets(String expression) {
        Stack bStack = new Stack();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                bStack.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                if (bStack.isEmpty()) {
                    return false;
                } else {
                    bStack.pop();
                }
            }
        }
        if (bStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        System.out.print("Nhap bieu thuc can kiem tra: ");
//        String expression = sc.nextLine();
//        if (checkBrackets(expression)) {
//            System.out.println("Bieu thuc " + expression + " su dung dau ngoac dung");
//        } else {
//            System.out.println("Bieu thuc " + expression + " su dung dau ngoac sai");
//        }
        List<String> expressions = new ArrayList<>();
        expressions.add("s * (s – a) * (s – b) * (s – c)");
        expressions.add("(– b + (b^2 – 4*a*c)^0.5) / 2*a");
        expressions.add("s * (s – a) * (s – b * (s – c)");
        expressions.add("s * (s – a) * s – b) * (s – c)");
        expressions.add("(– b + (b^2 – 4*a*c)^(0.5/ 2*a))");
        for (int i = 0; i < expressions.size(); i++) {
            if (checkBrackets(expressions.get(i))) {
                System.out.println("Bieu thuc " + expressions.get(i) + " su dung dau ngoac dung");
            } else {
                System.out.println("Bieu thuc " + expressions.get(i) + " su dung dau ngoac sai");
            }
        }
    }
}
