package furama_resort.controllers;

import furama_resort.commons.CustomerSortingComparator;
import furama_resort.commons.Standardization;
import furama_resort.commons.Validation;
import furama_resort.models.*;
import furama_resort.services.*;

import java.util.*;

public class MainController {
    private static final int SERVICE_VILLA = 1;
    private static final int SERVICE_HOUSE = 2;
    private static final int SERVICE_ROOM = 3;

    Scanner sc = new Scanner(System.in);
    BookingManager bookingManager = new BookingManager();
    VillaManager villaManager = new VillaManager();
    HouseManager houseManager = new HouseManager();
    RoomManager roomManager = new RoomManager();
    CustomerManager customerManager = new CustomerManager();
    EmployeeManager employeeManager = new EmployeeManager();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }

    public void displayMainMenu() {
        while (true) {
            System.out.print("\nWELCOME TO FURAMA RESORT\n" +
                    "Select an option from the list below:\n" +
                    "1.	Add New Service\n" +
                    "2.	Show Services\n" +
                    "3.	Add New Customer\n" +
                    "4.	Show Information of Customer\n" +
                    "5.	Add New Booking\n" +
                    "6.	Manage Cinema Service\n" +
                    "7.	Show Information of Employee\n" +
                    "8.	Manage Filing Cabinet\n" +
                    "9.	Exit\n" +
                    "Enter your choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("\n====== Add New Service ======");
                    addNewServices();
                    break;
                case "2":
                    System.out.println("\n====== Show Services ======");
                    showServices();
                    break;
                case "3":
                    System.out.println("\n====== Add New Customer ======");
                    addNewCustomer();
                    break;
                case "4":
                    System.out.println("\n====== List of Customers ======");
                    showInformationCustomers();
                    break;
                case "5":
                    System.out.println("\n====== Add New Booking ======");
                    addNewBooking();
                    break;
                case "6":
                    System.out.println("\n====== Manage Cinema Service ======");
                    manageCinemaService();
                    break;
                case "7":
                    System.out.println("\n====== List of Employees ======");
                    showInformationEmployees();
                    break;
                case "8":
                    System.out.println("\n====== Manage Filing Cabinet ======");
                    manageFilingCabinet();
                    break;
                case "9":
                    System.exit(0);
                default:
                    System.out.println("Input is out of range");
            }
        }
    }

    public void addNewServices() {
        while (true) {
            System.out.print("Select an option from the list below:\n" +
                    "1.	Add New Villa\n" +
                    "2.	Add New House\n" +
                    "3.	Add New Room\n" +
                    "4.	Back to Menu\n" +
                    "5.	Exit\n" +
                    "Enter your choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("\n====== Add New Villa ======");
                    addNewVilla();
                    break;
                case "2":
                    System.out.println("\n====== Add New House ======");
                    addNewHouse();
                    break;
                case "3":
                    System.out.println("\n====== Add New Room ======");
                    addNewRoom();
                    break;
                case "4":
                    displayMainMenu();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Input is out of range");
            }
        }
    }

    public List<String> addNewService(int serviceType) {
        List<String> service = new ArrayList<>();
        String serviceId;
        do {
            System.out.print("\nEnter service id: ");
            serviceId = sc.nextLine();
        } while (!Validation.validateServiceId(serviceId, serviceType));
        service.add(serviceId);

        String serviceName;
        do {
            System.out.print("Enter service name: ");
            serviceName = sc.nextLine();
        } while (!Validation.validateString(serviceName));
        service.add(serviceName);

        String usableArea;
        do {
            System.out.print("Enter usable area: ");
            usableArea = sc.nextLine();
        } while (!Validation.validateArea(usableArea));
        service.add(usableArea);

        String rentalCost;
        do {
            System.out.print("Enter rental cost: ");
            rentalCost = sc.nextLine();
        } while (!Validation.validatePositiveNumber(rentalCost));
        service.add(rentalCost);

        String maxNoOfPeople;
        do {
            System.out.print("Enter max number of people: ");
            maxNoOfPeople = sc.nextLine();
        } while (!Validation.validateNoOfPeople(maxNoOfPeople));
        service.add(maxNoOfPeople);

        String rentalType;
        do {
            System.out.print("Enter rental type: ");
            rentalType = sc.nextLine();
        } while (!Validation.validateRentalType(rentalType));
        service.add(rentalType);

        return service;
    }

    public void addNewVilla() {
        List<String> service = addNewService(SERVICE_VILLA);
        String roomStandard;
        do {
            System.out.print("Enter room standard: ");
            roomStandard = sc.nextLine();
        } while (!Validation.validateString(roomStandard));
        service.add(roomStandard);

        String otherFacilities;
        do {
            System.out.print("Enter other facilities: ");
            otherFacilities = sc.nextLine().trim();
        } while (!Validation.isNotEmpty(otherFacilities));
        service.add(otherFacilities);

        String poolArea;
        do {
            System.out.print("Enter pool area: ");
            poolArea = sc.nextLine();
        } while (!Validation.validateArea(poolArea));
        service.add(poolArea);

        String noOfFloors;
        do {
            System.out.print("Enter number of floors: ");
            noOfFloors = sc.nextLine();
        } while (!Validation.validatePositiveNumber(noOfFloors));
        service.add(noOfFloors);

        String[] villaInput = service.toArray(new String[0]);
        Villa villa = new Villa(villaInput);
        villaManager.add(villa);
    }

    public void addNewHouse() {
        List<String> service = addNewService(SERVICE_HOUSE);
        String roomStandard;
        do {
            System.out.print("Enter room standard: ");
            roomStandard = sc.nextLine();
        } while (!Validation.validateString(roomStandard));
        service.add(roomStandard);

        String otherFacilities;
        do {
            System.out.print("Enter other facilities: ");
            otherFacilities = sc.nextLine().trim();
        } while (!Validation.isNotEmpty(otherFacilities));
        service.add(otherFacilities);

        String noOfFloors;
        do {
            System.out.print("Enter number of floors: ");
            noOfFloors = sc.nextLine();
        } while (!Validation.validatePositiveNumber(noOfFloors));
        service.add(noOfFloors);

        String[] houseInput = service.toArray(new String[0]);
        House house = new House(houseInput);
        houseManager.add(house);
    }

    public void addNewRoom() {
        List<String> service = addNewService(SERVICE_ROOM);
        String freeServicesIncluded;
        do {
            System.out.print("Enter free services included: ");
            freeServicesIncluded = sc.nextLine().trim();
        } while (!Validation.isNotEmpty(freeServicesIncluded));
        service.add(freeServicesIncluded);

        String[] roomInput = service.toArray(new String[0]);
        Room room = new Room(roomInput);
        roomManager.add(room);
    }

    public void showServices() {
        while (true) {
            System.out.print("Select an option from the list below:\n" +
                    "1.	Show All Villa\n" +
                    "2.	Show All House\n" +
                    "3.	Show All Room\n" +
                    "4.	Show All Name Villa Not Duplicate\n" +
                    "5.	Show All Name House Not Duplicate\n" +
                    "6.	Show All Name Room Not Duplicate\n" +
                    "7.	Back to menu\n" +
                    "8.	Exit\n" +
                    "Enter your choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.println("\n====== List of Villas ======");
                    showAllVilla();
                    break;
                case "2":
                    System.out.println("\n====== List of Houses ======");
                    showAllHouse();
                    break;
                case "3":
                    System.out.println("\n====== List of Rooms ======");
                    showAllRoom();
                    break;
                case "4":
                    System.out.println("\n====== List of Villa Names ======");
                    showAllNameVilla();
                    break;
                case "5":
                    System.out.println("\n====== List of Houses Names ======");
                    showAllNameHouse();
                    return;
                case "6":
                    System.out.println("\n====== List of Rooms Names ======");
                    showAllNameRoom();
                    return;
                case "7":
                    displayMainMenu();
                    break;
                case "8":
                    System.exit(0);
                default:
                    System.out.println("Input is out of range");
            }
        }
    }

    public List<Villa> showAllVilla() {
        List<Villa> listVilla = villaManager.findAll();
        for (int i = 0; i < listVilla.size(); i++) {
            System.out.print((i + 1) + ". ");
            listVilla.get(i).showInfor();
        }
        return listVilla;
    }

    public List<House> showAllHouse() {
        List<House> listHouse = houseManager.findAll();
        for (int i = 0; i < listHouse.size(); i++) {
            System.out.print((i + 1) + ". ");
            listHouse.get(i).showInfor();
        }
        return listHouse;
    }

    public List<Room> showAllRoom() {
        List<Room> listRoom = roomManager.findAll();
        for (int i = 0; i < listRoom.size(); i++) {
            System.out.print((i + 1) + ". ");
            listRoom.get(i).showInfor();
        }
        return listRoom;
    }

    public void showAllNameVilla() {
        Set<String> listNameVilla = villaManager.findAllName();
        for (String name : listNameVilla) {
            System.out.println(name);
        }
    }

    public void showAllNameHouse() {
        Set<String> listNameHouse = houseManager.findAllName();
        for (String name : listNameHouse) {
            System.out.println(name);
        }
    }

    public void showAllNameRoom() {
        Set<String> listNameRoom = roomManager.findAllName();
        for (String name : listNameRoom) {
            System.out.println(name);
        }
    }

    public void addNewCustomer() {
        String customerName;
        do {
            System.out.print("\nEnter customer name: ");
            customerName = sc.nextLine();
        } while (!Validation.validateString(customerName));

        String customerBirthday;
        do {
            System.out.print("Enter customer birthday (dd/mm/yyyy): ");
            customerBirthday = sc.nextLine();
        } while (!Validation.validateBirthday(customerBirthday));

        String customerGender;
        do {
            System.out.print("Enter customer gender (Male/Female/Unknown): ");
            customerGender = sc.nextLine();
        } while (!Validation.validateGender(customerGender));
        customerGender = Standardization.standardizeString(customerGender);

        String customerIdNumber;
        do {
            System.out.print("Enter customer id card number (XXX XXX XXX): ");
            customerIdNumber = sc.nextLine();
        } while (!Validation.validateIdCard(customerIdNumber));

        String customerPhone;
        do {
            System.out.print("Enter customer phone number: ");
            customerPhone = sc.nextLine();
        } while (!Validation.validatePhone(customerPhone));

        String customerEmail;
        do {
            System.out.print("Enter customer email: ");
            customerEmail = sc.nextLine();
        } while (!Validation.validateEmail(customerEmail));

        String customerType;
        do {
            System.out.print("Enter customer type: ");
            customerType = sc.nextLine();
        } while (!Validation.validateString(customerType));

        String customerAddress;
        do {
            System.out.print("Enter customer address: ");
            customerAddress = sc.nextLine();
        } while (!Validation.validateAddress(customerAddress));

        String[] customerInfo = {customerName, customerBirthday, customerGender, customerIdNumber,
                customerPhone, customerEmail, customerType, customerAddress};
        Customer customer = new Customer(customerInfo);
        customerManager.add(customer);
    }

    public void showInformationCustomers() {
        List<Customer> listCustomer = customerManager.findAll();
        listCustomer.sort(new CustomerSortingComparator());
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ". ");
            listCustomer.get(i).showInfor();
        }
    }

    public void addNewBooking() {
        int customerIndex = chooseCustomer();
        List<Customer> listCustomer = customerManager.findAll();
        Customer customer = listCustomer.get(customerIndex);

        String serviceId = null;
        boolean flag = true;
        do {
            System.out.print("\nSelect an option from the list below:\n" +
                    "1.	Booking Villa\n" +
                    "2.	Booking House\n" +
                    "3.	Booking Room\n" +
                    "4.	Back to Menu\n" +
                    "5.	Exit\n" +
                    "Enter your choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    serviceId = bookVilla();
                    flag = false;
                    break;
                case "2":
                    serviceId = bookHouse();
                    flag = false;
                    break;
                case "3":
                    serviceId = bookRoom();
                    flag = false;
                    break;
                case "4":
                    displayMainMenu();
                    break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("Input is out of range");
            }
        } while (flag);
        String externalServices = bookExternalServices();
        bookingManager.addNewBooking(customer, serviceId, externalServices);
    }

    public int chooseCustomer() {
        List<Customer> listCustomer = customerManager.findAll();
        for (int i = 0; i < listCustomer.size(); i++) {
            System.out.print((i + 1) + ". ");
            listCustomer.get(i).showInfor();
        }
        int index;
        do {
            System.out.print("\nSelect a customer: ");
            try {
                index = Integer.parseInt(sc.nextLine());
                if (index > 0 && index <= listCustomer.size()) {
                    index -= 1;
                    return index;
                } else {
                    System.out.println("Index is out of range");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer and is the index of chosen customer");
            }
        } while (true);
    }

    public String bookVilla() {
        List<Villa> listVilla = showAllVilla();
        int index;
        do {
            System.out.print("\nSelect a villa: ");
            try {
                index = Integer.parseInt(sc.nextLine());
                if (index > 0 && index <= listVilla.size()) {
                    index -= 1;
                    return listVilla.get(index).getServiceId();
                } else {
                    System.out.println("Index is out of range");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer and is the index of chosen villa");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index is out of range");
            }
        } while (true);
    }

    public String bookHouse() {
        List<House> listHouse = showAllHouse();
        int index;
        do {
            System.out.print("\nSelect a house: ");
            try {
                index = Integer.parseInt(sc.nextLine());
                if (index > 0 && index <= listHouse.size()) {
                    index -= 1;
                    return listHouse.get(index).getServiceId();
                } else {
                    System.out.println("Index is out of range");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer and is the index of chosen house");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index is out of range");
            }
        } while (true);
    }

    public String bookRoom() {
        List<Room> listRoom = showAllRoom();
        int index;
        while (true) {
            System.out.print("\nSelect a room: ");
            try {
                index = Integer.parseInt(sc.nextLine());
                if (index > 0 && index <= listRoom.size()) {
                    index -= 1;
                    return listRoom.get(index).getServiceId();
                } else {
                    System.out.println("Index is out of range");
                }
            } catch (NumberFormatException e) {
                System.out.println("Input must be an integer and is the index of chosen room");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index is out of range");
            }
        }

    }

    public String bookExternalServices() {
        String externalServices = "";
        while (true) {
            System.out.print("\nDo you want to book external services (y/n): ");
            String choice = sc.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                ExternalService service1 = new ExternalService("massage");
                ExternalService service2 = new ExternalService("karaoke");
                ExternalService service3 = new ExternalService("food");
                ExternalService service4 = new ExternalService("drink");
                ExternalService service5 = new ExternalService("car");
                do {
                    System.out.print(service1.getServiceName() + ": " + service1.getPrice() + " (" + service1.getUnit() + ")\n" +
                            service2.getServiceName() + ": " + service2.getPrice() + " (" + service2.getUnit() + ")\n" +
                            service3.getServiceName() + ": " + service3.getPrice() + " (" + service3.getUnit() + ")\n" +
                            service4.getServiceName() + ": " + service4.getPrice() + " (" + service4.getUnit() + ")\n" +
                            service5.getServiceName() + ": " + service5.getPrice() + " (" + service5.getUnit() + ")\n" +
                            "Enter name of services to book: ");
                    choice = sc.nextLine().trim().toLowerCase();
                } while (!Validation.validateExternalService(choice));
                externalServices += choice + "+";
            } else if (choice.equals("n")) {
                if (!externalServices.equals("")) {
                    externalServices = externalServices.substring(0, externalServices.length() - 1);
                }
                return externalServices;
            }
        }
    }

    public void manageCinemaService() {
        int noOfTickets = 5;
        Queue<Customer> customers = new LinkedList<>();
        while (true) {
            System.out.print("\nSelect an option from the list below:\n" +
                    "1.	Buy Cinema Ticket\n" +
                    "2.	Show All Customers\n" +
                    "3.	Back to menu\n" +
                    "4.	Exit\n" +
                    "Enter your choice: ");
            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    if (customers.size() >= noOfTickets) {
                        System.out.println("Tickets are sold out");
                    } else {
                        addNewBuying(customers);
                    }
                    break;
                case "2":
                    showCustomersBought(customers);
                    break;
                case "3":
                    displayMainMenu();
                    break;
                case "4":
                    System.exit(0);
                default:
                    System.out.println("Input is out of range");
            }
        }
    }

    public void addNewBuying(Queue<Customer> customers) {
        int customerIndex = chooseCustomer();
        List<Customer> listCustomer = customerManager.findAll();
        Customer customer = listCustomer.get(customerIndex);
        customers.offer(customer);
    }

    public void showCustomersBought(Queue<Customer> customers) {
        int index = 1;
        if (customers.size() == 5) {
            while (!customers.isEmpty()) {
                System.out.print(index + ". ");
                customers.poll().showInfor();
                index++;
            }
        } else {
            for (Customer customer : customers) {
                System.out.print(index + ". ");
                customer.showInfor();
                index++;
            }
        }
    }

    public void showInformationEmployees() {
        Map<String, Employee> employeeMap = employeeManager.getEmployeesData();
        Set<String> keySet = employeeMap.keySet();
        for (String key : keySet) {
            System.out.print(key + ": ");
            employeeMap.get(key).showInfor();
        }
    }

    public void manageFilingCabinet() {
        System.out.print("Enter the employee number you want to find: ");
        String employeeId = sc.nextLine();
        Map.Entry<String, Employee> file = employeeManager.getFile(employeeId);
        if (file == null) {
            System.out.println("No file of employee with id " + employeeId);
        }
    }

    //    public void editVilla() {
//        showAll(SERVICE_VILLA);
//        System.out.print("Enter id to edit: ");
//        String id = sc.nextLine();
//        System.out.print("Enter service name: ");
//        String serviceName = sc.nextLine();
//        System.out.print("Enter usable area: ");
//        double usableArea = Double.parseDouble(sc.nextLine());
//        System.out.print("Enter rental cost: ");
//        double rentalCost = Double.parseDouble(sc.nextLine());
//        System.out.print("Enter max number of people: ");
//        int maxNoOfPeople = Integer.parseInt(sc.nextLine());
//        System.out.print("Enter rental type: ");
//        String rentalType = sc.nextLine();
//                        System.out.print("Enter room standard: ");
//                String roomStandard = sc.nextLine();
//                System.out.print("Enter other facilities: ");
//                String otherFacilities = sc.nextLine();
//                System.out.print("Enter number of floors: ");
//                int noOfFloors = Integer.parseInt(sc.nextLine());
//                if (serviceType == SERVICE_VILLA) {
//                    System.out.print("Enter pool area: ");
//                    double poolArea = Double.parseDouble(sc.nextLine());
//                    Villa villa = new Villa(serviceId, serviceName, usableArea, rentalCost, maxNoOfPeople, rentalType, roomStandard, otherFacilities, poolArea, noOfFloors);
//                    villaManager.add(villa);
//    }
}
