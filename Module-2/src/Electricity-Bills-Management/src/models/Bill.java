package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Bill {
    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private String billId;
    private String customerId;
    private String invoiceDate;
    private int consumption;
    private double price;
    private double total;

    public Bill() {
    }

    public Bill(String customerId, String invoiceDate, int consumption, double price) {
        this.billId = getIncrementBillId();
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.consumption = consumption;
        this.price = price;
//        this.total = 0;
    }

    public Bill(String[] billInfo) {
        this.billId = billInfo[0];
        this.customerId = billInfo[1];
        this.invoiceDate = billInfo[2];
        this.consumption = Integer.parseInt(billInfo[3]);
        this.price = Double.parseDouble(billInfo[4]);
        this.total = Double.parseDouble(billInfo[5]);
    }

    public String getBillId() {
        return billId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getIncrementBillId() {
        int count = atomicInteger.incrementAndGet();
        String countStr = count + "";
        String billId = countStr;
        for (int i = 0; i < 3 - countStr.length(); i++) {
            billId = "0" + billId;
        }
        return "MHD-" + billId;
    }

    @Override
    public String toString() {
        return billId + ',' +
                customerId + ',' +
                invoiceDate + ',' +
                consumption + ',' +
                price + ',' +
                total;
    }
}
