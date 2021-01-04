package day_1_introduction_to_java.bai_tap;

import java.util.Scanner;

public class NumberToWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        int hundreds = number / 100;
        int tens = (number % 100) / 10;
        int ones = number % 10;
        String hundredsString = "";
        String tensString = "";
        String onesString = "";
        String result = "";

        switch (hundreds) {
            case 1:
                hundredsString = "one";
                break;
            case 2:
                hundredsString = "two";
                break;
            case 3:
                hundredsString = "three";
                break;
            case 4:
                hundredsString = "four";
                break;
            case 5:
                hundredsString = "five";
                break;
            case 6:
                hundredsString = "six";
                break;
            case 7:
                hundredsString = "seven";
                break;
            case 8:
                hundredsString = "eight";
                break;
            case 9:
                hundredsString = "nine";
                break;
        }
        switch (tens) {
            case 2:
                tensString = "twenty";
                break;
            case 3:
                tensString = "thirty";
                break;
            case 4:
                tensString = "forty";
                break;
            case 5:
                tensString = "fifty";
                break;
            case 6:
                tensString = "sixty";
                break;
            case 7:
                tensString = "seventy";
                break;
            case 8:
                tensString = "eighty";
                break;
            case 9:
                tensString = "ninety";
                break;
        }
        switch (ones) {
            case 1:
                onesString = "one";
                break;
            case 2:
                onesString = "two";
                break;
            case 3:
                onesString = "three";
                break;
            case 4:
                onesString = "four";
                break;
            case 5:
                onesString = "five";
                break;
            case 6:
                onesString = "six";
                break;
            case 7:
                onesString = "seven";
                break;
            case 8:
                onesString = "eight";
                break;
            case 9:
                onesString = "nine";
                break;
        }

        if (number < 0 || number > 999) {
            result = "out of ability";
        } else if (number == 0) {
            result = "zero";
        } else {
            if (number >= 100) {
                result += hundredsString + " hundred";
                if (tens != 0 || ones != 0) {
                    result += " and ";
                }
            }
            if (tens >= 2) {
                result += tensString + " " + onesString;
            } else if (tens == 1) {
                switch (ones) {
                    case 0:
                        result += "ten";
                        break;
                    case 1:
                        result += "eleven";
                        break;
                    case 2:
                        result += "twelve";
                        break;
                    case 3:
                        result += "thirteen";
                        break;
                    case 4:
                        result += "fourteen";
                        break;
                    case 5:
                        result += "fifteen";
                        break;
                    case 6:
                        result += "sixteen";
                        break;
                    case 7:
                        result += "seventeen";
                        break;
                    case 8:
                        result += "eighteen";
                        break;
                    case 9:
                        result += "nineteen";
                        break;
                }
            } else {
                result += onesString;
            }
        }
        System.out.println("Result: " + result);
    }
}
