package controllers;

import commons.Validation;
import models.Bill;
import models.Customer;
import models.Foreigner;
import models.Vietnamese;
import services.BillManager;
import services.CustomerManager;
import services.VietnameseManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static final int CUSTOMER_VIETNAMESE = 1;
    private static final int CUSTOMER_FOREIGNER = 2;
    //    private static final int VEHICLE_MOTORBIKE = 3;
//
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
                    showBillInfo();
                    break;
                case "7":
                    System.exit(0);
            }
        }
    }

    public void addNewCustomer() {
        while (true) {
            System.out.println("\nVui lòng chọn một lựa chọn trong danh sách dưới đây:\n"
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
        List<String> list = new ArrayList<>();
        String customerId;
        do {
            System.out.print("\nNhập mã khách hàng: ");
            customerId = sc.nextLine();
        } while (!Validation.validateCustomerId(customerId, customerNationality));
        list.add(customerId);

        String customerName;
        do {
            System.out.print("Nhập tên khách hàng: ");
            customerName = sc.nextLine();
        } while (Validation.isEmpty(customerName));
        list.add(customerName);

        return list;
    }

    public void addNewVietnamese() {
        List<String> list = addNewCustomer(CUSTOMER_VIETNAMESE);
        List<String[]> customerTypes = customerManager.findAllCustomerType();
        int typeIndex = 0;
        while (true) {
            System.out.println("Chọn loại khách hàng trong list sau:");
            customerManager.showAllCustomerType();
            try {
                typeIndex = Integer.parseInt(sc.nextLine());
                if (typeIndex > 0 && typeIndex <= customerTypes.size()) {
                    break;
                } else {
                    System.out.println("Chỉ mục bạn nhập không đúng.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập chỉ mục của loại khách hàng.");
            }
        }
        String customerType = customerTypes.get(typeIndex - 1)[1];
        list.add(customerType);

        int consumption = 0;
        while (true) {
            System.out.print("Nhập định mức tiêu thụ: ");
            try {
                consumption = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Định mức tiêu thụ phải là định dạng số.");
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
            System.out.print("Nhập quốc tịch của khách hàng: ");
            nationality = sc.nextLine();
        } while (Validation.isEmpty(nationality));
        list.add(nationality);

        String[] foreignerInfo = list.toArray(new String[0]);
        Foreigner foreigner = new Foreigner(foreignerInfo);
        customerManager.add(foreigner);
    }

    public void showAllCustomers() {
        System.out.println("==== Danh sách khách hàng ====");
        customerManager.showCustomers();
    }

    public void searchForCustomer() {
        boolean flag;
        do {
            flag = false;
            System.out.print("\nNhập tên khách hàng bạn muốn tìm: ");
            String customerName = sc.nextLine();
            Customer customer;
            if ((customer = customerManager.search(customerName)) != null) {
                customer.showInfo();
            } else {
                System.out.println("Không có khách hàng nào được tìm thấy.");
                while (true) {
                    System.out.println("Bạn có muốn tiếp tục tìm kiếm? (1. Có/ 2. Không)");
                    String choice = sc.nextLine();
                    if (choice.equals("1")) {
                        flag = true;
                        break;
                    } else if (choice.equals("2")) {
                        break;
                    }
                }
            }
        } while (flag);
    }

    public void addNewBill() {
        int customerIndex = chooseCustomer();
        List<Customer> listCustomer = customerManager.findAllCustomers();
        Customer customer = listCustomer.get(customerIndex);
        String customerId = customer.getCustomerId();

        String invoiceDate;
        do {
            System.out.print("Nhập ngày ra hóa đơn: ");
            invoiceDate = sc.nextLine();
        } while (Validation.isEmpty(invoiceDate));

        int consumption;
        while (true) {
            System.out.print("Nhập số lượng tiêu thụ: ");
            try {
                consumption = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số lượng tiêu thụ phải là định dạng số.");
            }
        }

        double price;
        while (true) {
            System.out.print("Nhập đơn giá: ");
            try {
                price = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Đơn giá phải là định dạng số.");
            }
        }
        Bill bill = new Bill(customerId, invoiceDate, consumption, price);
        double total = billManager.calculateTotal(customer, bill);
        bill.setTotal(total);
        billManager.add(bill);
    }

    public int chooseCustomer() {
        System.out.println("\nDanh sách khách hàng:");
        List<Customer> listCustomer = customerManager.findAllCustomers();
        customerManager.showCustomers();
        int index;
        do {
            System.out.print("Chọn một khách hàng trong danh sách trên: ");
            try {
                index = Integer.parseInt(sc.nextLine());
                if (index > 0 && index <= listCustomer.size()) {
                    index -= 1;
                    return index;
                } else {
                    System.out.println("Chỉ mục nhập vào không đúng");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chỉ mục nhập vào phải là số nguyên");
            }
        } while (true);
    }

    public void editBill() {

    }

    public void showBillInfo() {

    }

//    public void showAllVehicles() {
//        while (true) {
//            System.out.println("\nChọn chức năng:\n"
//                    + "1. Hiển thị xe tải\n"
//                    + "2. Hiển thị ô tô\n"
//                    + "3. Hiển thị xe máy\n"
//                    + "4. Trở về menu trước\n"
//                    + "5. Thoát");
//            String choice = sc.nextLine();
//            System.out.println();
//            switch (choice) {
//                case "1":
//                    showAllTrucks();
//                    break;
//                case "2":
//                    showAllCars();
//                    break;
//                case "3":
//                    showAllMotorbikes();
//                    break;
//                case "4":
//                    displayMenu();
//                    break;
//                case "5":
//                    System.exit(0);
//            }
//        }
//    }
//
//    public void showAllTrucks() {
//        List<Truck> list = truckManager.findAll();
//        for (Truck truck : list) {
//            truck.showInfo();
//        }
//    }
//
//    public void showAllCars() {
//        List<Car> list = carManager.findAll();
//        for (Car car : list) {
//            car.showInfo();
//        }
//    }
//
//    public void showAllMotorbikes() {
//        List<Motorbike> list = motorbikeManager.findAll();
//        for (Motorbike motorbike : list) {
//            motorbike.showInfo();
//        }
//    }
//
//    public void updateVehicleInfo() {
//        while (true) {
//            System.out.print("\nNhập số biển kiểm soát của phương tiện muốn sửa: ");
//            String noPlate = sc.nextLine();
//            Vehicle vehicle;
//            int vehicleType = 0;
//            if ((vehicle = truckManager.findById(noPlate)) != null) {
//                vehicleType = 1;
//            } else if ((vehicle = carManager.findById(noPlate)) != null) {
//                vehicleType = 2;
//            } else if ((vehicle = motorbikeManager.findById(noPlate)) != null) {
//                vehicleType = 3;
//            }
//            try {
//                switch (vehicleType) {
//                    case 0:
//                        throw new NotFoundVehicelException();
//                    case 1:
//                        editTruck((Truck) vehicle);
//                        break;
//                    case 2:
//                        editCar((Car) vehicle);
//                        break;
//                    case 3:
//                        editMotorbike((Motorbike) vehicle);
//                        break;
//                }
////                while (true) {
////                    System.out.println("Xác nhận xóa phương tiện với biển kiểm soát " + noPlate + "? (1. Yes/2. No)");
////                    String choice = sc.nextLine();
////                    if (choice.equals("1")) {
////                        switch (vehicleType) {
////                            case 1:
////                                truckManager.delete(noPlate);
////                                break;
////                            case 2:
////                                carManager.delete(noPlate);
////                                break;
////                            case 3:
////                                motorbikeManager.delete(noPlate);
////                                break;
////                        }
////                        System.out.println("Đã xóa thành công");
////                        return;
////                    } else if (choice.equals("2")) {
////                        return;
////                    }
////                }
//            } catch (NotFoundVehicelException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    public void editTruck(Truck truck) {
//        String noPlate = truck.getNoPlate();
//        boolean flag;
//        try {
//            do {
//                System.out.println("\nChọn thông tin muốn sửa:\n" +
//                        "1. Biển kiểm soát\n" +
//                        "2. Hãng sản xuất\n" +
//                        "3. Năm sản xuất\n" +
//                        "4. Chủ sở hữu\n" +
//                        "5. Tải trọng\n" +
//                        "6. Trở về");
//                String choice = sc.nextLine();
//                switch (choice) {
//                    case "1":
//                        String newNoPlate;
//                        do {
//                            System.out.print("\nNhập số biển kiểm soát: ");
//                            newNoPlate = sc.nextLine();
//                        } while (!Validation.validateNoPlate(newNoPlate, VEHICLE_TRUCK));
//                        truck.setNoPlate(newNoPlate);
//                    case "2":
//                        List<String[]> listBrands = BrandManager.findAllBrand();
//                        int brandIndex = 0;
//                        while (true) {
//                            System.out.println("Chọn hãng sản xuất trong list sau:");
//                            BrandManager.showAllBrand();
//                            try {
//                                brandIndex = Integer.parseInt(sc.nextLine());
//                                if (brandIndex > 0 && brandIndex <= listBrands.size()) {
//                                    break;
//                                } else {
//                                    System.out.println("Chỉ mục bạn nhập không đúng.");
//                                }
//                            } catch (NumberFormatException e) {
//                                System.out.println("Vui lòng nhập chỉ mục của hãng sản xuất.");
//                            }
//                        }
//                        String brand = listBrands.get(brandIndex - 1)[1];
//                        truck.setBrand(brand);
//                    case "3":
//                        int yearOfProduction = 0;
//                        while (true) {
//                            System.out.print("Nhập năm sản xuất: ");
//                            try {
//                                yearOfProduction = Integer.parseInt(sc.nextLine());
//                                break;
//                            } catch (NumberFormatException e) {
//                                System.out.println("Năm sản xuất phải là định dạng số.");
//                            }
//                        }
//                        truck.setYearOfProduction(yearOfProduction);
//                    case "4":
//                        String owner;
//                        do {
//                            System.out.print("Nhập tên chủ sở hữu: ");
//                            owner = sc.nextLine();
//                        } while (Validation.isEmpty(owner));
//                        truck.setOwner(owner);
//                    case "5":
//                        int payload = 0;
//                        while (true) {
//                            System.out.print("Nhập tải trọng: ");
//                            try {
//                                payload = Integer.parseInt(sc.nextLine());
//                                break;
//                            } catch (NumberFormatException e) {
//                                System.out.println("Tải trọng phải là định dạng số.");
//                            }
//                        }
//                        truck.setPayload(payload);
//                    case "6":
//                        return;
//                    default:
//                        System.out.println("Chỉ mục nhập vào không đúng.");
//                }
//                while (true) {
//                    System.out.println("Có cần sửa thêm thông tin nào không? (1. Có/ 2. Không)");
//                    choice = sc.nextLine();
//                    if (choice == "1") {
//                        flag = true;
//                        break;
//                    } else if (choice == "2") {
//                        flag = false;
//                        break;
//                    }
//                }
//            } while (flag);
//        } finally {
//            while (true) {
//                System.out.println("Xác nhận lưu thay đổi? (1. Có/ 2. Không)");
//                String choice = sc.nextLine();
//                if (choice == "1") {
//                    truckManager.edit(truck, noPlate);
//                    System.out.println("Lưu chỉnh sửa thành công.");
//                    return;
//                } else if (choice == "2") {
//                    return;
//                }
//            }
//        }
//    }
//
//    public void editCar(Car car) {
//        System.out.println("\nChọn thông tin muốn sửa:\n" +
//                "1. Biển kiểm soát\n" +
//                "2. Hãng sản xuất\n" +
//                "3. Năm sản xuất\n" +
//                "4. Chủ sở hữu\n" +
//                "5. Số chỗ ngồi\n" +
//                "6. Kiểu xe");
//        String choice = sc.nextLine();
//    }
//
//    public void editMotorbike(Motorbike motorbike) {
//        System.out.println("\nChọn thông tin muốn sửa:\n" +
//                "1. Biển kiểm soát\n" +
//                "2. Hãng sản xuất\n" +
//                "3. Năm sản xuất\n" +
//                "4. Chủ sở hữu\n" +
//                "5. Công suất");
//        String choice = sc.nextLine();
//    }
//
//    public void removeVehicle() {
//        while (true) {
//            System.out.print("\nNhập số biển kiểm soát của phương tiện muốn xóa: ");
//            String noPlate = sc.nextLine();
//            int vehicleType = 0;
//            if (truckManager.findById(noPlate) != null) {
//                vehicleType = 1;
//            } else if (carManager.findById(noPlate) != null) {
//                vehicleType = 2;
//            } else if (motorbikeManager.findById(noPlate) != null) {
//                vehicleType = 3;
//            }
//            try {
//                if (vehicleType == 0) {
//                    throw new NotFoundVehicelException();
//                }
//                while (true) {
//                    System.out.println("Xác nhận xóa phương tiện với biển kiểm soát " + noPlate + "? (1. Yes/2. No)");
//                    String choice = sc.nextLine();
//                    if (choice.equals("1")) {
//                        switch (vehicleType) {
//                            case 1:
//                                truckManager.delete(noPlate);
//                                break;
//                            case 2:
//                                carManager.delete(noPlate);
//                                break;
//                            case 3:
//                                motorbikeManager.delete(noPlate);
//                                break;
//                        }
//                        System.out.println("Đã xóa thành công");
//                        return;
//                    } else if (choice.equals("2")) {
//                        return;
//                    }
//                }
//            } catch (NotFoundVehicelException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
}
