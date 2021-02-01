package day_17_string_and_regex.bai_tap;

import java.util.regex.Pattern;

public class ValidateClassName {
    private static final String CLASSNAME_REGEX = "^[CAP][0-9]{4}[GHIKLM]$";

    public static boolean validateClassName(String regex) {
        return Pattern.matches(CLASSNAME_REGEX, regex);
    }

    public static final String[] validClassName = new String[]{"C0318G"};
    public static final String[] invalidClassName = new String[]{"M0318G", "P0323A"};

    public static void main(String args[]) {
        for (String className : validClassName) {
            boolean isvalid = validateClassName(className);
            System.out.println("Class name is " + className + " is valid: " + isvalid);
        }
        for (String className : invalidClassName) {
            boolean isvalid = validateClassName(className);
            System.out.println("Class name is " + className + " is valid: " + isvalid);
        }
    }
}
