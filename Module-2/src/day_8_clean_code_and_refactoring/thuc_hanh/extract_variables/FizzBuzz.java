package day_8_clean_code_and_refactoring.thuc_hanh.extract_variables;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;
        if (isFizz && isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }
}
