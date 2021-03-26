package model;

import java.sql.Date;

public class Order {
    private String paymentType;
    private Customer customer;
    private Employee employee;
    private Date orderDate;
    private Date shipDate;
    private String shipAddress;

    public Order(String paymentType, Customer customer, Employee employee, Date orderDate, Date shipDate, String shipAddress) {
        this.paymentType = paymentType;
        this.customer = customer;
        this.employee = employee;
        this.orderDate = orderDate;
        this.shipDate = shipDate;
        this.shipAddress = shipAddress;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
}
