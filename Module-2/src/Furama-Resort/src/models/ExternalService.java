package models;

public class ExternalService {
    private String serviceName;
    private String unit;
    private double price;

    public ExternalService(String serviceName) {
        this.serviceName = serviceName;
        switch (serviceName) {
            case "massage":
                this.unit = "hour";
                this.price = 15;
                break;
            case "karaoke":
                this.unit = "hour";
                this.price = 10;
                break;
            case "food":
                this.unit = "portion/person";
                this.price = 7;
                break;
            case "drink":
                this.unit = "portion/person";
                this.price = 4;
                break;
            case "car":
                this.unit = "day";
                this.price = 100;
        }
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return serviceName + ',' +
                unit + ',' +
                price;
    }
}
