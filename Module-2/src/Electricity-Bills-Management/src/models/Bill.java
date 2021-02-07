package models;

public class Bill {
    private String billId;
    private String customerId;
    private String invoiceDate;
    private int consumption;
    private int price;
    private int total;

    public Bill() {
    }

    public Bill(String billId, String customerId, String invoiceDate, int consumption, int price) {
        this.billId = billId;
        this.customerId = customerId;
        this.invoiceDate = invoiceDate;
        this.consumption = consumption;
        this.price = price;
    }

    public Bill(String[] billInfo) {
        this.billId = billInfo[0];
        this.customerId = billInfo[1];
        this.invoiceDate = billInfo[2];
        this.consumption = Integer.parseInt(billInfo[3]);
        this.price = Integer.parseInt(billInfo[4]);
        this.total = Integer.parseInt(billInfo[5]);
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    public void showInfo() {
        System.out.println("Bill{" +
                "billId='" + billId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", consumption=" + consumption +
                ", price=" + price +
                ", total=" + total +
                '}');
    }
}
