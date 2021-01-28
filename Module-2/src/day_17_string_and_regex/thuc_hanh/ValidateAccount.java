package day_17_string_and_regex.thuc_hanh;

import java.util.regex.Pattern;

public class ValidateAccount {
    private static final String ACCOUNT_REGEX = "^[a-z0-9_]{6,}$";

    public static boolean validateAccount(String regex) {
        return Pattern.matches(ACCOUNT_REGEX, regex);
    }

    public static final String[] validAccount = new String[]{"123abc_", "_abc123", "______", "123456", "abcdefgh"};
    public static final String[] invalidAccount = new String[]{".@", "12345", "1234_", "abcde"};

    public static void main(String args[]) {
        for (String account : validAccount) {
            boolean isvalid = validateAccount(account);
            System.out.println("Account is " + account + " is valid: " + isvalid);
        }
        for (String account : invalidAccount) {
            boolean isvalid = validateAccount(account);
            System.out.println("Account is " + account + " is valid: " + isvalid);
        }
    }
}
