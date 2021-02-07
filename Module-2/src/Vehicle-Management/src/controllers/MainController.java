package controllers;

import commons.NotFoundVehicelException;
import commons.Validation;
import models.Car;
import models.Motorbike;
import models.Truck;
import models.Vehicle;
import services.BrandManager;
import services.CarManager;
import services.MotorbikeManager;
import services.TruckManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private static final int VEHICLE_TRUCK = 1;
    private static final int VEHICLE_CAR = 2;
    private static final int VEHICLE_MOTORBIKE = 3;

    Scanner sc = new Scanner(System.in);
    TruckManager truckManager = new TruckManager();
    CarManager carManager = new CarManager();
    MotorbikeManager motorbikeManager = new MotorbikeManager();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMenu();
    }

    public void displayMenu() {
        while (true) {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG\n"
                    + "Chọn chức năng:\n"
                    + "1. Thêm mới phương tiện\n"
                    + "2. Hiển thị phương tiện\n"
                    + "3. Chỉnh sửa phương tiện\n"
                    + "4. Xóa phương tiện\n"
                    + "5. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNewVehicle();
                    break;
                case "2":
                    showAllVehicles();
                    break;
                case "3":
                    updateVehicleInfo();
                    break;
                case "4":
                    removeVehicle();
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }

    public void addNewVehicle() {
        while (true) {
            System.out.println("\nChọn chức năng:\n"
                    + "1. Thêm xe tải\n"
                    + "2. Thêm ô tô\n"
                    + "3. Thêm xe máy\n"
                    + "4. Trở về menu trước\n"
                    + "5. Thoát");
            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                    addNewTruck();
                    break;
                case "2":
                    addNewCar();
                    break;
                case "3":
                    addNewMotorbike();
                    break;
                case "4":
                    displayMenu();
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }

    public List<String> addVehicle(int vehicleType) {
        List<String> list = new ArrayList<>();
        String noPlate;
        do {
            System.out.print("\nNhập số biển kiểm soát: ");
            noPlate = sc.nextLine();
        } while (!Validation.validateNoPlate(noPlate, vehicleType));
        list.add(noPlate);

        List<String[]> listBrands = BrandManager.findAllBrand();
        int brandIndex = 0;
        while (true) {
            System.out.println("Chọn hãng sản xuất trong list sau:");
            BrandManager.showAllBrand();
            try {
                brandIndex = Integer.parseInt(sc.nextLine());
                if (brandIndex > 0 && brandIndex <= listBrands.size()) {
                    break;
                } else {
                    System.out.println("Chỉ mục bạn nhập không đúng.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập chỉ mục của hãng sản xuất.");
            }
        }
        String brand = listBrands.get(brandIndex - 1)[1];
        list.add(brand);

        int yearOfProduction = 0;
        while (true) {
            System.out.print("Nhập năm sản xuất: ");
            try {
                yearOfProduction = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Năm sản xuất phải là định dạng số.");
            }
        }
        list.add(yearOfProduction + "");

        String owner;
        do {
            System.out.print("Nhập tên chủ sở hữu: ");
            owner = sc.nextLine();
        } while (Validation.isEmpty(owner));
        list.add(owner);

        return list;
    }

    public void addNewTruck() {
        List<String> list = addVehicle(VEHICLE_TRUCK);

        int payload = 0;
        while (true) {
            System.out.print("Nhập tải trọng: ");
            try {
                payload = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Tải trọng phải là định dạng số.");
            }
        }
        list.add(payload + "");

        String[] truckInfo = list.toArray(new String[0]);
        Truck truck = new Truck(truckInfo);
        truckManager.add(truck);
    }

    public void addNewCar() {
        List<String> list = addVehicle(VEHICLE_CAR);

        int noOfSeats = 0;
        while (true) {
            System.out.print("Nhập số chỗ ngồi: ");
            try {
                noOfSeats = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Số chỗ ngồi phải là định dạng số.");
            }
        }
        list.add(noOfSeats + "");

        String model;
        do {
            System.out.print("Nhập kiểu xe: ");
            model = sc.nextLine();
        } while (Validation.isEmpty(model));
        list.add(model);

        String[] carInfo = list.toArray(new String[0]);
        Car car = new Car(carInfo);
        carManager.add(car);
    }

    public void addNewMotorbike() {
        List<String> list = addVehicle(VEHICLE_MOTORBIKE);

        int capacity = 0;
        while (true) {
            System.out.print("Nhập công suất: ");
            try {
                capacity = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Công suất phải là định dạng số.");
            }
        }
        list.add(capacity + "");

        String[] motorbikeInfo = list.toArray(new String[0]);
        Motorbike motorbike = new Motorbike(motorbikeInfo);
        motorbikeManager.add(motorbike);
    }

    public void showAllVehicles() {
        while (true) {
            System.out.println("\nChọn chức năng:\n"
                    + "1. Hiển thị xe tải\n"
                    + "2. Hiển thị ô tô\n"
                    + "3. Hiển thị xe máy\n"
                    + "4. Trở về menu trước\n"
                    + "5. Thoát");
            String choice = sc.nextLine();
            System.out.println();
            switch (choice) {
                case "1":
                    showAllTrucks();
                    break;
                case "2":
                    showAllCars();
                    break;
                case "3":
                    showAllMotorbikes();
                    break;
                case "4":
                    displayMenu();
                    break;
                case "5":
                    System.exit(0);
            }
        }
    }

    public void showAllTrucks() {
        List<Truck> list = truckManager.findAll();
        for (Truck truck : list) {
            truck.showInfo();
        }
    }

    public void showAllCars() {
        List<Car> list = carManager.findAll();
        for (Car car : list) {
            car.showInfo();
        }
    }

    public void showAllMotorbikes() {
        List<Motorbike> list = motorbikeManager.findAll();
        for (Motorbike motorbike : list) {
            motorbike.showInfo();
        }
    }

    public void updateVehicleInfo() {
        while (true) {
            System.out.print("\nNhập số biển kiểm soát của phương tiện muốn sửa: ");
            String noPlate = sc.nextLine();
            Vehicle vehicle;
            int vehicleType = 0;
            if ((vehicle = truckManager.findById(noPlate)) != null) {
                vehicleType = 1;
            } else if ((vehicle = carManager.findById(noPlate)) != null) {
                vehicleType = 2;
            } else if ((vehicle = motorbikeManager.findById(noPlate)) != null) {
                vehicleType = 3;
            }
            try {
                switch (vehicleType) {
                    case 0:
                        throw new NotFoundVehicelException();
                    case 1:
                        editTruck((Truck) vehicle);
                        break;
                    case 2:
                        editCar((Car) vehicle);
                        break;
                    case 3:
                        editMotorbike((Motorbike) vehicle);
                        break;
                }
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
            } catch (NotFoundVehicelException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void editTruck(Truck truck) {
        String noPlate = truck.getNoPlate();
        boolean flag;
        try {
            do {
                System.out.println("\nChọn thông tin muốn sửa:\n" +
                        "1. Biển kiểm soát\n" +
                        "2. Hãng sản xuất\n" +
                        "3. Năm sản xuất\n" +
                        "4. Chủ sở hữu\n" +
                        "5. Tải trọng\n" +
                        "6. Trở về");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        String newNoPlate;
                        do {
                            System.out.print("\nNhập số biển kiểm soát: ");
                            newNoPlate = sc.nextLine();
                        } while (!Validation.validateNoPlate(newNoPlate, VEHICLE_TRUCK));
                        truck.setNoPlate(newNoPlate);
                    case "2":
                        List<String[]> listBrands = BrandManager.findAllBrand();
                        int brandIndex = 0;
                        while (true) {
                            System.out.println("Chọn hãng sản xuất trong list sau:");
                            BrandManager.showAllBrand();
                            try {
                                brandIndex = Integer.parseInt(sc.nextLine());
                                if (brandIndex > 0 && brandIndex <= listBrands.size()) {
                                    break;
                                } else {
                                    System.out.println("Chỉ mục bạn nhập không đúng.");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Vui lòng nhập chỉ mục của hãng sản xuất.");
                            }
                        }
                        String brand = listBrands.get(brandIndex - 1)[1];
                        truck.setBrand(brand);
                    case "3":
                        int yearOfProduction = 0;
                        while (true) {
                            System.out.print("Nhập năm sản xuất: ");
                            try {
                                yearOfProduction = Integer.parseInt(sc.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Năm sản xuất phải là định dạng số.");
                            }
                        }
                        truck.setYearOfProduction(yearOfProduction);
                    case "4":
                        String owner;
                        do {
                            System.out.print("Nhập tên chủ sở hữu: ");
                            owner = sc.nextLine();
                        } while (Validation.isEmpty(owner));
                        truck.setOwner(owner);
                    case "5":
                        int payload = 0;
                        while (true) {
                            System.out.print("Nhập tải trọng: ");
                            try {
                                payload = Integer.parseInt(sc.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Tải trọng phải là định dạng số.");
                            }
                        }
                        truck.setPayload(payload);
                    case "6":
                        return;
                    default:
                        System.out.println("Chỉ mục nhập vào không đúng.");
                }
                while (true) {
                    System.out.println("Có cần sửa thêm thông tin nào không? (1. Có/ 2. Không)");
                    choice = sc.nextLine();
                    if (choice == "1") {
                        flag = true;
                        break;
                    } else if (choice == "2") {
                        flag = false;
                        break;
                    }
                }
            } while (flag);
        } finally {
            while (true) {
                System.out.println("Xác nhận lưu thay đổi? (1. Có/ 2. Không)");
                String choice = sc.nextLine();
                if (choice == "1") {
                    truckManager.edit(truck, noPlate);
                    System.out.println("Lưu chỉnh sửa thành công.");
                    return;
                } else if (choice == "2") {
                    return;
                }
            }
        }
    }

    public void editCar(Car car) {
        System.out.println("\nChọn thông tin muốn sửa:\n" +
                "1. Biển kiểm soát\n" +
                "2. Hãng sản xuất\n" +
                "3. Năm sản xuất\n" +
                "4. Chủ sở hữu\n" +
                "5. Số chỗ ngồi\n" +
                "6. Kiểu xe");
        String choice = sc.nextLine();
    }

    public void editMotorbike(Motorbike motorbike) {
        System.out.println("\nChọn thông tin muốn sửa:\n" +
                "1. Biển kiểm soát\n" +
                "2. Hãng sản xuất\n" +
                "3. Năm sản xuất\n" +
                "4. Chủ sở hữu\n" +
                "5. Công suất");
        String choice = sc.nextLine();
    }

    public void removeVehicle() {
        while (true) {
            System.out.print("\nNhập số biển kiểm soát của phương tiện muốn xóa: ");
            String noPlate = sc.nextLine();
            int vehicleType = 0;
            if (truckManager.findById(noPlate) != null) {
                vehicleType = 1;
            } else if (carManager.findById(noPlate) != null) {
                vehicleType = 2;
            } else if (motorbikeManager.findById(noPlate) != null) {
                vehicleType = 3;
            }
            try {
                if (vehicleType == 0) {
                    throw new NotFoundVehicelException();
                }
                while (true) {
                    System.out.println("Xác nhận xóa phương tiện với biển kiểm soát " + noPlate + "? (1. Yes/2. No)");
                    String choice = sc.nextLine();
                    if (choice.equals("1")) {
                        switch (vehicleType) {
                            case 1:
                                truckManager.delete(noPlate);
                                break;
                            case 2:
                                carManager.delete(noPlate);
                                break;
                            case 3:
                                motorbikeManager.delete(noPlate);
                                break;
                        }
                        System.out.println("Đã xóa thành công");
                        return;
                    } else if (choice.equals("2")) {
                        return;
                    }
                }
            } catch (NotFoundVehicelException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
