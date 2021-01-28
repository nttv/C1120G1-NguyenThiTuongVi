package FuramaResort.Controllers;

import FuramaResort.Models.House;
import FuramaResort.Models.Room;
import FuramaResort.Models.Villa;
import FuramaResort.Services.HouseManager;
import FuramaResort.Services.RoomManager;
import FuramaResort.Services.VillaManager;

import java.util.List;
import java.util.Scanner;

public class MainController {
    Scanner sc = new Scanner(System.in);
    VillaManager villaManager = new VillaManager();
    HouseManager houseManager = new HouseManager();
    RoomManager roomManager = new RoomManager();

    public static void main(String[] args) {
        MainController mainController = new MainController();
        mainController.displayMainMenu();
    }

    public void displayMainMenu() {
        while (true) {
            System.out.print("\nSelect a function from the list below:\n" +
                    "1.	Add New Service\n" +
                    "2.	Show Services\n" +
                    "3.	Add New Customer\n" +
                    "4.	Show Information of Customer\n" +
                    "5.	Add New Booking\n" +
                    "6.	Show Information of Employee\n" +
                    "7.	Exit\n" +
                    "Enter your choice: ");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    //addNewCustomer();
                    break;
                case 4:
                    //showInformationCustomers();
                    break;
                case 5:
                    //addNewBooking();
                    break;
                case 6:
                    //showInformationEmployees();
                    break;
                case 7:
                    return;
            }
        }
    }

    public void addNewServices() {
        System.out.print("\nSelect a function from the list below:\n" +
                "1.	Add New Villa\n" +
                "2.	Add New House\n" +
                "3.	Add New Room\n" +
                "4.	Back to menu\n" +
                "5.	Exit\n" +
                "Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                addNewVilla();
                break;
            case 2:
                addNewHouse();
                break;
            case 3:
                addNewRoom();
                break;
            case 4:
                displayMainMenu();
                break;
            case 5:
                return;
        }
    }

    public void showServices() {
        System.out.print("\nSelect an option from the list below:\n" +
                "1.	Show all Villa\n" +
                "2.	Show all House\n" +
                "3.	Show all Room\n" +
                "4.	Show All Name Villa Not Duplicate\n" +
                "5.	Show All Name House Not Duplicate\n" +
                "6.	Show All Name Rooma Not Duplicate\n" +
                "7.	Back to menu\n" +
                "8.	Exit\n" +
                "Enter your choice: ");
        int choice = Integer.parseInt(sc.nextLine());
        switch (choice) {
            case 1:
                showAllVilla();
                break;
            case 2:
                showAllHouse();
                break;
            case 3:
                showAllRoom();
                break;
            case 4:
                break;
            case 5:
                return;
            case 6:
                return;
            case 7:
                displayMainMenu();
                break;
            case 8:
                return;
        }
    }

    public void addNewVilla() {
        System.out.print("\nEnter service id: ");
        String serviceId = sc.nextLine();
        System.out.print("Enter service name: ");
        String serviceName = sc.nextLine();
        System.out.print("Enter usable area: ");
        int usableArea = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental cost: ");
        int rentalCost = Integer.parseInt(sc.nextLine());
        System.out.print("Enter max number of people: ");
        int maxNoOfPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        System.out.print("Enter room standard: ");
        String roomStandard = sc.nextLine();
        System.out.print("Enter other facilities: ");
        String otherFacilities = sc.nextLine();
        System.out.print("Enter pool area: ");
        int poolArea = Integer.parseInt(sc.nextLine());
        System.out.print("Enter number of floors: ");
        int noOfFloors = Integer.parseInt(sc.nextLine());
        Villa villa = new Villa(serviceId, serviceName, usableArea, rentalCost, maxNoOfPeople, rentalType, roomStandard, otherFacilities, poolArea, noOfFloors);
        villaManager.add(villa);
    }

    public void addNewHouse() {
        System.out.print("\nEnter service id: ");
        String serviceId = sc.nextLine();
        System.out.print("Enter service name: ");
        String serviceName = sc.nextLine();
        System.out.print("Enter usable area: ");
        int usableArea = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental cost: ");
        int rentalCost = Integer.parseInt(sc.nextLine());
        System.out.print("Enter max number of people: ");
        int maxNoOfPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        System.out.print("Enter room standard: ");
        String roomStandard = sc.nextLine();
        System.out.print("Enter other facilities: ");
        String otherFacilities = sc.nextLine();
        System.out.print("Enter number of floors: ");
        int noOfFloors = Integer.parseInt(sc.nextLine());
        House house = new House(serviceId, serviceName, usableArea, rentalCost, maxNoOfPeople, rentalType, roomStandard, otherFacilities, noOfFloors);
        houseManager.add(house);
    }

    public void addNewRoom() {
        System.out.print("\nEnter service id: ");
        String serviceId = sc.nextLine();
        System.out.print("Enter service name: ");
        String serviceName = sc.nextLine();
        System.out.print("Enter usable area: ");
        int usableArea = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental cost: ");
        int rentalCost = Integer.parseInt(sc.nextLine());
        System.out.print("Enter max number of people: ");
        int maxNoOfPeople = Integer.parseInt(sc.nextLine());
        System.out.print("Enter rental type: ");
        String rentalType = sc.nextLine();
        System.out.print("Enter free services included: ");
        String freeServicesIncluded = sc.nextLine();
        Room room = new Room(serviceId, serviceName, usableArea, rentalCost, maxNoOfPeople, rentalType, freeServicesIncluded);
        roomManager.add(room);
    }

    public void showAllVilla() {
        List<Villa> listVilla = villaManager.findAll();
        for (Villa villa : listVilla) {
            villa.showInfor();
        }
    }

    public void showAllHouse() {
        List<House> listHouse = houseManager.findAll();
        for (House house : listHouse) {
            house.showInfor();
        }
    }

    public void showAllRoom() {
        List<Room> listRoom = roomManager.findAll();
        for (Room room : listRoom) {
            room.showInfor();
        }
    }
}
