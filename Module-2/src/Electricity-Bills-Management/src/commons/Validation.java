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
            System.out.println("Trường này là bắt buộc nhập");
            return true;
        }
    }

    public static boolean validateCustomerId(String customerId, int customerNationality) {
        if (!Pattern.matches(CUSTOMER_ID_REGEX, customerId)) {
            System.out.println("Mã khách hàng sai định dạng KH(VN|NN)-XXXXX");
            return false;
        }
        String signal = customerId.substring(2, 4);
        switch (customerNationality) {
            case CUSTOMER_VIETNAMESE:
                if (!signal.equals("VN")) {
                    System.out.println("Mã khách hàng sai định dạng KHVN-XXXXX");
                    return false;
                }
                break;
            case CUSTOMER_FOREIGNER:
                if (!signal.equals("NN")) {
                    System.out.println("Mã khách hàng sai định dạng KHNN-XXXXX");
                    return false;
                }
        }
        if (validateExistCustomerId(customerId)) {
            System.out.println("Mã khách hàng đã tồn tại");
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
