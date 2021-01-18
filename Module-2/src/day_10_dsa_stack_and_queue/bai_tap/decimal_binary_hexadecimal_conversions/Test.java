package day_10_dsa_stack_and_queue.bai_tap.decimal_binary_hexadecimal_conversions;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a decimal: ");
        float decimal = sc.nextFloat();
        Converter converter = new Converter();
        String binary = converter.decimalToBinary(decimal);
        System.out.println("Result of converting " + decimal + " decimal to binary: " + binary);
    }
}
