package FuramaResort.Models;

public abstract class Services {
    private String serviceId;
    private String serviceName;
    private int usableArea;
    private int rentalCost;
    private int maxNoOfPeople;
    private String rentalType;

    public Services() {
    }

    public Services(String serviceId, String serviceName, int usableArea, int rentalCost, int maxNoOfPeople, String rentalType) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maxNoOfPeople = maxNoOfPeople;
        this.rentalType = rentalType;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(int usableArea) {
        this.usableArea = usableArea;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxNoOfPeople() {
        return maxNoOfPeople;
    }

    public void setMaxNoOfPeople(int maxNoOfPeople) {
        this.maxNoOfPeople = maxNoOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Services{" +
                "serviceId='" + serviceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", usableArea=" + usableArea +
                ", rentalCost=" + rentalCost +
                ", maxNoOfPeople=" + maxNoOfPeople +
                ", rentalType='" + rentalType + '\'' +
                '}';
    }

    public abstract void showInfor();
}
