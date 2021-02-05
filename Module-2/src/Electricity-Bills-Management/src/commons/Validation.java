package commons;

import java.util.regex.Pattern;

public class Validation {
    private static final String NOT_EMPTY_REGEX = "^\\w.*$";

    public static boolean isEmpty(String string) {
        if (Pattern.matches(NOT_EMPTY_REGEX, string)) {
            return false;
        } else {
            System.out.println("Trường này là bắt buộc nhập");
            return true;
        }
    }

    public static boolean validateCustomerId(String customerId, int customerNationality) {
        return true;
    }
}
