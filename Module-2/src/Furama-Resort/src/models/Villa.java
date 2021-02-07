package models;

public class Villa extends Service {
    private String roomStandard;
    private String otherFacilities;
    private double poolArea;
    private int noOfFloors;

    public Villa() {
    }

    public Villa(String serviceId, String serviceName, double usableArea, double rentalCost, int maxNoOfPeople,
                 String rentalType, String roomStandard, String otherFacilities, double poolArea, int noOfFloors) {
        super(serviceId, serviceName, usableArea, rentalCost, maxNoOfPeople, rentalType);
        this.roomStandard = roomStandard;
        this.otherFacilities = otherFacilities;
        this.poolArea = poolArea;
        this.noOfFloors = noOfFloors;
    }

    public Villa(String[] villaInfo) {
        super(villaInfo[0], villaInfo[1], Double.parseDouble(villaInfo[2]),
                Double.parseDouble(villaInfo[3]), Integer.parseInt(villaInfo[4]), villaInfo[5]);
        this.roomStandard = villaInfo[6];
        this.otherFacilities = villaInfo[7];
        this.poolArea = Double.parseDouble(villaInfo[8]);
        this.noOfFloors = Integer.parseInt(villaInfo[9]);
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
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
                poolArea + ',' +
                noOfFloors;
    }

    @Override
    public void showInfor() {
        System.out.println("Villa {serviceId='" + getServiceId() + '\'' +
                ", serviceName='" + getServiceName() + '\'' +
                ", usableArea=" + getUsableArea() +
                ", rentalCost=" + getRentalCost() +
                ", maxNoOfPeople=" + getMaxNoOfPeople() +
                ", rentalType='" + getRentalType() + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", otherFacilities='" + otherFacilities + '\'' +
                ", poolArea=" + poolArea +
                ", noOfFloors=" + noOfFloors + "}");
    }

    public static void main(String[] args) {
        Service service = new Villa("1", "Villa", 200, 1000, 5, "monthly", "Vip", "Pool", 200, 3);
        service.showInfor();
    }
}
