package FuramaResort.Models;

public class Room extends Services {
    private String freeServicesIncluded;

    public Room() {
    }

    public Room(String serviceId, String serviceName, int usableArea, int rentalCost, int maxNoOfPeople, String rentalType, String freeServicesIncluded) {
        super(serviceId, serviceName, usableArea, rentalCost, maxNoOfPeople, rentalType);
        this.freeServicesIncluded = freeServicesIncluded;
    }

    public Room(String[] roomInfo) {
        super(roomInfo[0], roomInfo[1], Integer.parseInt(roomInfo[2]), Integer.parseInt(roomInfo[3]), Integer.parseInt(roomInfo[4]), roomInfo[5]);
        this.freeServicesIncluded = roomInfo[6];
    }

    public String getFreeServicesIncluded() {
        return freeServicesIncluded;
    }

    public void setFreeServicesIncluded(String freeServicesIncluded) {
        this.freeServicesIncluded = freeServicesIncluded;
    }

    @Override
    public String toString() {
        return getServiceId() + ',' +
                getServiceName() + ',' +
                getUsableArea() + ',' +
                getRentalCost() + ',' +
                getMaxNoOfPeople() + ',' +
                getRentalType() + ',' +
                freeServicesIncluded;
    }

    @Override
    public void showInfor() {
        System.out.println("House{" +
                "serviceId='" + getServiceId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", usableArea=" + getUsableArea() +
                ", rentalCost=" + getRentalCost() +
                ", maxNoOfPeople=" + getMaxNoOfPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                ", freeServicesIncluded='" + freeServicesIncluded + '\'' +
                '}');
    }
}
