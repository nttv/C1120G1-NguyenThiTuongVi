package models;

public class Vietnamese extends Customer {
    private String customerType;
    private int consumption;

    public Vietnamese() {
    }

    public Vietnamese(String customerId, String customerName, String customerType, int consumption) {
        super(customerId, customerName);
        this.customerType = customerType;
        this.consumption = consumption;
    }

    public Vietnamese(String[] customerInfo) {
        super(customerInfo[0], customerInfo[1]);
        this.customerType = customerInfo[2];
        this.consumption = Integer.parseInt(customerInfo[3]);
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    @Override
    public String toString() {
        return super.toString() + ',' + customerType + ',' + consumption;
    }

    @Override
    public void showInfo() {
        System.out.println("Vietnamese{" +
                "customerId='" + super.getCustomerId() + '\'' +
                ", customerName='" + super.getCustomerName() + '\'' +
                ", customerType='" + customerType + '\'' +
                ", consumption=" + consumption +
                '}');
    }
}
