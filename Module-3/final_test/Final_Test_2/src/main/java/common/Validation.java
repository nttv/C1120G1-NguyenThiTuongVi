package common;

import java.util.regex.Pattern;

public class Validation {
    private static final String NAME_REQUIRE_REGEX = "^[A-Z][A-Za-z\\s\\d]*$";

    public static String validateProductName(String productName) {
        String messageName = null;
        if (!Pattern.matches(NAME_REQUIRE_REGEX, productName)) {
            messageName = "Truong nay khong duoc de trong.";
        }
        return messageName;
    }

    public static String validatePrice(int price) {
        String messagePrice = null;
        if (price <= 100) {
            messagePrice = "Gia phai lon hon 100.";
        }
        return messagePrice;
    }

    public static String validateStock(int stock) {
        String messageStock = null;
        if (stock <= 10) {
            messageStock = "Ton kho phai lon hon 10.";
        }
        return messageStock;
    }
}
