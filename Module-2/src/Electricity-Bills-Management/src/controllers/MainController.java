package controllers;

import commons.Validation;
import models.Bill;
import models.Customer;
import models.Foreigner;
import models.Vietnamese;
import services.BillManager;
import services.CustomerManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static final int CUSTOMER_VIETNAMESE = 1;
    private static final int CUSTOMER_FOREIGNER = 2;

    Scanner sc = new Scanner(System.in);

    CustomerManager customerManager = new CustomerManager();
    BillManager billManager = new BillManager();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMenu();
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ HÓA ĐƠN TIỀN ĐIỆN\n"
                    + "Chọn chức năng:\n"
                    + "1. Thêm mới khách hàng\n"
                    + "2. Hiển thị thông tin khách hàng\n"
                    + "3. Tìm kiếm khách hàng\n"
                    + "4. Thêm mới hóa đơn\n"
                    + "5. Chỉnh sửa hóa đơn\n"
                    + "6. Hiển thị thông tin chi tiết hóa đơn\n"
                    + "7. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNewCustomer();
                    break;
                case "2":
                    showAllCustomers();
                    break;
                case "3":
                    searchForCustomer();
                    break;
                case "4":
                    addNewBill();
                    break;
                case "5":
                    editBill();
                    break;
                case "6":
                    showAllBills();
                    break;
                case "7":
                    System.exit(0);
            }
        }
    }

    public void addNewCustomer() {
        while (true) {
            System.out.println("\nVUI LÒNG CHỌN MỘT LỰA CHỌN TRONG DANH SÁCH DƯỚI ĐÂY:\n"
                    + "1. Thêm khách hàng Việt Nam\n"
                    + "2. Thêm khách hàng nước ngoài\n"
                    + "3. Trở về menu trước\n"
                    + "4. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNewVietnamese();
                    break;
                case "2":
                    addNewForeigner();
                    break;
                case "3":
                    displayMenu();
                    break;
                case "4":
                    System.exit(0);
            }
        }
    }

    public List<String> addNewCustomer(int customerNationality) {
        System.out.println("\n==== THÊM KHÁCH HÀNG MỚI ====");
        List<String> list = new ArrayList<>();
        String customerId;
        do {
            System.out.print("NHẬP MÃ KHÁCH HÀNG: ");
            customerId = sc.nextLine();
        } while (!Validation.validateCustomerId(customerId, customerNationality));
        list.add(customerId);

        String customerName;
        do {
            System.out.print("NHẬP TÊN KHÁCH HÀNG: ");
            customerName = sc.nextLine();
        } while (Validation.isEmpty(customerName));
        list.add(customerName);

        return list;
    }

    public void addNewVietnamese() {
        List<String> list = addNewCustomer(CUSTOMER_VIETNAMESE);
        List<String[]> customerTypes = customerManager.findAllCustomerType();
        int typeIndex;
        while (true) {
            System.out.println("CHỌN LOẠI KHÁCH HÀNG TRONG DANH SÁCH SAU:");
            customerManager.showAllCustomerType();
            while (true) {
                try {
                    typeIndex = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("VUI LÒNG NHẬP CHỈ MỤC CỦA LOẠI KHÁCH HÀNG");
                }
            }
            if (typeIndex > 0 && typeIndex <= customerTypes.size()) {
                break;
            } else {
                System.out.println("CHỈ MỤC BẠN NHẬP KHÔNG ĐÚNG");
            }
        }
        String customerType = customerTypes.get(typeIndex - 1)[1];
        list.add(customerType);

        int consumption = 0;
        while (true) {
            System.out.print("NHẬP ĐỊNH MỨC TIÊU THỤ: ");
            try {
                consumption = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ĐỊNH MỨC TIÊU THỤ PHẢI LÀ ĐỊNH DẠNG SỐ");
            }
        }
        list.add(consumption + "");

        String[] vietnameseInfo = list.toArray(new String[0]);
        Vietnamese vietnamese = new Vietnamese(vietnameseInfo);
        customerManager.add(vietnamese);
    }

    public void addNewForeigner() {
        List<String> list = addNewCustomer(CUSTOMER_FOREIGNER);
        String nationality;
        do {
            System.out.print("NHẬP QUỐC TỊCH CỦA KHÁCH HÀNG: ");
            nationality = sc.nextLine();
        } while (Validation.isEmpty(nationality));
        list.add(nationality);

        String[] foreignerInfo = list.toArray(new String[0]);
        Foreigner foreigner = new Foreigner(foreignerInfo);
        customerManager.add(foreigner);
    }

    public void showAllCustomers() {
        System.out.println("\n==== DANH SÁCH KHÁCH HÀNG ====");
        customerManager.showCustomers();
    }

    public void searchForCustomer() {
        System.out.println("\n==== TÌM KHÁCH HÀNG ====");
        while (true) {
            System.out.print("NHẬP TÊN KHÁCH HÀNG BẠN MUỐN TÌM: ");
            String customerName = sc.nextLine();
            Customer customer;
            if ((customer = customerManager.findCustomerByName(customerName)) != null) {
                customer.showInfo();
                return;
            }
            System.out.println("KHÔNG CÓ KHÁCH HÀNG NÀO ĐƯỢC TÌM THẤY");
            while (true) {
                System.out.println("BẠN CÓ MUỐN TIẾP TỤC TÌM KIẾM? (1.CÓ | 2.KHÔNG)");
                String choice = sc.nextLine();
                if (choice.equals("1")) {
                    break;
                } else if (choice.equals("2")) {
                    return;
                }
            }
        }
    }

    public void addNewBill() {
        System.out.println("\n==== THÊM HÓA ĐƠN MỚI ====");
        String billId = billManager.getIncrementBillId();
        Customer customer = chooseCustomer();
        String customerId = customer.getCustomerId();

        String invoiceDate;
        do {
            System.out.print("NHẬP NGÀY RA HÓA ĐƠN: ");
            invoiceDate = sc.nextLine();
        } while (Validation.isEmpty(invoiceDate));

        int consumption;
        while (true) {
            System.out.print("NHẬP SỐ LƯỢNG TIÊU THỤ: ");
            try {
                consumption = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("SỐ LƯỢNG TIÊU THỤ PHẢI LÀ ĐỊNH DẠNG SỐ");
            }
        }

        int price;
        while (true) {
            System.out.print("NHẬP ĐƠN GIÁ: ");
            try {
                price = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("ĐƠN GIÁ PHẢI LÀ ĐỊNH DẠNG SỐ");
            }
        }
        Bill bill = new Bill(billId, customerId, invoiceDate, consumption, price);
        int total = billManager.calculateTotal(bill);
        bill.setTotal(total);
        billManager.add(bill);
    }

    public Customer chooseCustomer() {
        System.out.println("DANH SÁCH KHÁCH HÀNG:");
        List<Customer> listCustomer = customerManager.findAllCustomers();
        customerManager.showCustomers();
        int index;
        do {
            System.out.print("CHỌN MỘT KHÁCH HÀNG TRONG DANH SÁCH TRÊN: ");
            while (true) {
                try {
                    index = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("CHỈ MỤC NHẬP VÀO PHẢI LÀ SỐ NGUYÊN");
                }
            }
            if (index > 0 && index <= listCustomer.size()) {
                return listCustomer.get(index - 1);
            } else {
                System.out.println("CHỈ MỤC NHẬP VÀO KHÔNG ĐÚNG");
            }
        } while (true);
    }

    public void editBill() {
        System.out.println("\n==== DANH SÁCH HÓA ĐƠN ====");
        billManager.showAllBills();
        List<Bill> list = billManager.findAllBills();
        int index;
        while (true) {
            System.out.print("CHỌN HÓA ĐƠN MUỐN CHỈNH SỬA TỪ DANH SÁCH HÓA ĐƠN TRÊN: ");
            while (true) {
                try {
                    index = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("CHỈ MỤC NHẬP VÀO PHẢI LÀ SỐ NGUYÊN");
                }
            }
            if (index > 0 && index <= list.size()) {
                index -= 1;
                break;
            } else {
                System.out.println("CHỈ MỤC NHẬP VÀO KHÔNG ĐÚNG");
            }
        }
        String newCustomerId;
        while (true) {
            System.out.print("NHẬP MÃ KHÁCH HÀNG MỚI: ");
            newCustomerId = sc.nextLine();
            if (Validation.validateExistCustomerId(newCustomerId)) {
                break;
            }
            System.out.println("MÃ KHÁCH HÀNG KHÔNG TỒN TẠI");
            while (true) {
                System.out.println("BẠN CÓ MUỐN THỬ LẠI? (1.CÓ | 2.KHÔNG)");
                String choice = sc.nextLine();
                if (choice.equals("1")) {
                    break;
                } else if (choice.equals("2")) {
                    return;
                }
            }
        }
        Bill newBill = list.get(index);
        newBill.setCustomerId(newCustomerId);
        billManager.edit(newBill, newBill.getBillId());
        System.out.println("CHỈNH SỬA THÀNH CÔNG");
    }

    public void showAllBills() {
        System.out.println("\n==== DANH SÁCH HÓA ĐƠN ====");
        billManager.showAllBills();
        while (true) {
            System.out.println("BẠN CÓ MUỐN XEM CHI TIẾT HÓA ĐƠN? (1.CÓ | 2.KHÔNG)");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                showBillDetail();
                return;
            } else if (choice.equals("2")) {
                return;
            }
        }
    }

    public void showBillDetail() {
        List<Bill> list = billManager.findAllBills();
        int index;
        boolean flag = false;
        while (true) {
            System.out.print("CHỌN MỘT HÓA ĐƠN TỪ DANH SÁCH HÓA ĐƠN TRÊN: ");
            while (true) {
                try {
                    index = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("CHỈ MỤC NHẬP VÀO PHẢI LÀ SỐ NGUYÊN");
                }
            }
            if (index > 0 && index <= list.size()) {
                System.out.println("\n==== CHI TIẾT HÓA ĐƠN ====");
                billManager.showBillDetail(list.get(index - 1));
                return;
            }
            System.out.println("CHỈ MỤC NHẬP VÀO KHÔNG ĐÚNG");
            while (true) {
                System.out.println("BẠN CÓ MUỐN THỬ LẠI? (1.CÓ | 2.KHÔNG)");
                String choice = sc.nextLine();
                if (choice.equals("1")) {
                    break;
                } else if (choice.equals("2")) {
                    return;
                }
            }
        }
    }
}
