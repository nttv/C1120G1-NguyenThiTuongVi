package models;

public class House extends Service {
    private String roomStandard;
    private String otherFacilities;
    private int noOfFloors;

    public House() {
    }

    public House(String serviceId, String serviceName, double usableArea, double rentalCost, int maxNoOfPeople,
                 String rentalType, String roomStandard, String otherFacilities, int noOfFloors) {
        super(serviceId, serviceName, usableArea, rentalCost, maxNoOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.otherFacilities = otherFacilities;
        this.noOfFloors = noOfFloors;
    }

    public House(String[] houseInfo) {
        super(houseInfo[0], houseInfo[1], Double.parseDouble(houseInfo[2]),
                Double.parseDouble(houseInfo[3]), Integer.parseInt(houseInfo[4]), houseInfo[5]);
        this.roomStandard = houseInfo[6];
        this.otherFacilities = houseInfo[7];
        this.noOfFloors = Integer.parseInt(houseInfo[8]);
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getOtherFacilities() {
        return otherFacilities;
    }

    public void setOtherFacilities(String otherFacilities) {
        this.otherFacilities = otherFacilities;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() + ',' +
                roomStandard + ',' +
                otherFacilities + ',' +
                noOfFloors;
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
                ", roomStandard='" + roomStandard + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", noOfFloors=" + noOfFloors +
                '}');
    }
}
