package day_17_string_and_regex.thuc_hanh;

import java.util.regex.Pattern;

public class ValidateEmail {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";

    public static boolean validateEmail(String regex) {
        return Pattern.matches(EMAIL_REGEX, regex);
    }

    public static final String[] validEmail = new String[]{"a@gmail.com", "ab@yahoo.com", "abc@hotmail.com"};
    public static final String[] invalidEmail = new String[]{"@gmail.com", "ab@gmail.", "@#abc@gmail.com"};

    public static void main(String args[]) {
        for (String email : validEmail) {
            boolean isvalid = validateEmail(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
        for (String email : invalidEmail) {
            boolean isvalid = validateEmail(email);
            System.out.println("Email is " + email + " is valid: " + isvalid);
        }
    }
}
