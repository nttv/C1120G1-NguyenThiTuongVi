package day_17_string_and_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidatePhone {
    private static final String PHONE_REGEX = "^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";

    public static boolean validatePhone(String regex) {
        return Pattern.matches(PHONE_REGEX, regex);
    }

    public static final String[] validPhone = new String[]{"(84)-(0978489648)"};
    public static final String[] invalidPhone = new String[]{"(a8)-(22222222)"};

    public static void main(String args[]) {
        for (String phone : validPhone) {
            boolean isvalid = validatePhone(phone);
            System.out.println("Phone is " + phone + " is valid: " + isvalid);
        }
        for (String phone : invalidPhone) {
            boolean isvalid = validatePhone(phone);
            System.out.println("Phone is " + phone + " is valid: " + isvalid);
        }
    }
}
