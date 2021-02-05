package models;

public class Foreigner extends Customer {
    private String nationality;

    public Foreigner() {
    }

    public Foreigner(String customerId, String customerName, String nationality) {
        super(customerId, customerName);
        this.nationality = nationality;
    }

    public Foreigner(String[] customerInfo) {
        super(customerInfo[0], customerInfo[1]);
        this.nationality = customerInfo[2];
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    @Override
    public String toString() {
        return super.toString() + ',' + nationality;
    }

    @Override
    public void showInfo() {
        System.out.println("Foreigner{" +
                "customerId='" + super.getCustomerId() + '\'' +
                ", customerName='" + super.getCustomerName() + '\'' +
                ", nationality='" + nationality +
                '}');
    }
}
