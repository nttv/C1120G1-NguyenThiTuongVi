package day_10_dsa_stack_and_queue.bai_tap.decimal_binary_hexadecimal_conversions;

import java.util.*;

public class Converter {
    private String fractionToBinary(float fraction) {
        Queue<Integer> fractionConvert = new LinkedList<>();
        do {
            fraction *= 2;
            if (fraction < 1) {
                fractionConvert.add(0);
            } else {
                fractionConvert.add(1);
                fraction -= 1;
            }
        } while (fraction != 0);
        String result = ".";
        while (!fractionConvert.isEmpty()) {
            result += fractionConvert.remove();
        }
        return result;
    }

    private String integerToBinary(int integer) {
        Stack<Integer> integerConvert = new Stack<>();
        int quotient = integer;
        int remainder;
        while (quotient != 0) {
            remainder = quotient % 2;
            quotient /= 2;
            integerConvert.push(remainder);
        }
        while (integerConvert.size() < 8) {
            integerConvert.push(0);
        }
        String result = "";
        while (!integerConvert.isEmpty()) {
            result += integerConvert.pop();
        }
        return result;
    }

    private String toNegative(String binary) {
        String[] result = binary.split("");
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals("0")) {
                result[i] = "1";
            } else if (result[i].equals("1")) {
                result[i] = "0";
            }
        }
        for (int i = result.length - 1; i >= 0; i--) {
            if (result[i].equals("0")) {
                result[i] = "1";
                break;
            } else if (result[i].equals("1")) {
                result[i] = "0";
            }
        }
        String negativeBinary = "";
        for (String s : result) {
            negativeBinary += s;
        }
        return negativeBinary;
    }

    public String decimalToBinary(float decimal) {
        float positiveNum = Math.abs(decimal);
        int integer = (int) Math.floor(positiveNum);
        float fraction = positiveNum - integer;
        String binary = integerToBinary(integer);
        if (fraction > 0) {
            binary += fractionToBinary(fraction);
        }
        if (decimal < 0) {
            binary = toNegative(binary);
        }
        return binary;
    }

//    public int binaryToDecimal(String binary) {
//        int decimal = 0;
//
//        return decimal;
//    }
//
//    public String decimalToHexa(int decimal) {
//        String hexa = "";
//
//        return hexa;
//    }
//
//    public int hexaToDecimal(String hexa) {
//        int decimal = 0;
//
//        return decimal;
//    }
}
