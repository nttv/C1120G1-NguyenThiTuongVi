package commons;

import models.Customer;
import services.CustomerManager;

import java.util.List;
import java.util.regex.Pattern;

public class Validation {
    private static final int CUSTOMER_VIETNAMESE = 1;
    private static final int CUSTOMER_FOREIGNER = 2;

    private static final String NOT_EMPTY_REGEX = "^\\w.*$";
    private static final String CUSTOMER_ID_REGEX = "^KH(VN|NN)-\\d{5}$";

    public static boolean isEmpty(String string) {
        if (Pattern.matches(NOT_EMPTY_REGEX, string)) {
            return false;
        } else {
            System.out.println("TRƯỜNG NÀY LÀ BẮT BUỘC NHẬP GIÁ TRỊ");
            return true;
        }
    }

    public static boolean validateCustomerId(String customerId, int customerNationality) {
        if (!Pattern.matches(CUSTOMER_ID_REGEX, customerId)) {
            System.out.println("MÃ KHÁCH HÀNG SAI ĐỊNH DẠNG KH(VN|NN)-XXXXX");
            return false;
        }
        String signal = customerId.substring(2, 4);
        switch (customerNationality) {
            case CUSTOMER_VIETNAMESE:
                if (!signal.equals("VN")) {
                    System.out.println("MÃ KHÁCH HÀNG SAI ĐỊNH DẠNG KHVN-XXXXX");
                    return false;
                }
                break;
            case CUSTOMER_FOREIGNER:
                if (!signal.equals("NN")) {
                    System.out.println("MÃ KHÁCH HÀNG SAI ĐỊNH DẠNG KHNN-XXXXX");
                    return false;
                }
        }
        if (validateExistCustomerId(customerId)) {
            System.out.println("MÃ KHÁCH HÀNG ĐÃ TỒN TẠI");
            return false;
        }
        return true;
    }

    public static boolean validateExistCustomerId(String customerId) {
        List<Customer> list = new CustomerManager().findAllCustomers();
        for (Customer customer : list) {
            if (customer.getCustomerId().equals(customerId)) {
                return true;
            }
        }
        return false;
    }
}
