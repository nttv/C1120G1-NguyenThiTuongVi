package services;

import commons.FuncReadAndWrite;
import models.Bill;
import models.Customer;
import models.Vietnamese;

import java.util.ArrayList;
import java.util.List;

public class BillManager {
    FuncReadAndWrite<Bill> funcReadAndWrite = new FuncReadAndWrite<>();

    public String getIncrementBillId() {
        List<Bill> list = findAllBills();
        int lastId = Integer.parseInt(list.get(list.size() - 1).getBillId().substring(4));
        String idStr = ++lastId + "";
        String billId = idStr;
        for (int i = 0; i < 3 - idStr.length(); i++) {
            billId = "0" + billId;
        }
        return "MHD-" + billId;
    }

    public List<Bill> findAllBills() {
        List<String[]> list = funcReadAndWrite.readFile("bill.csv");
        List<Bill> listBills = new ArrayList<>();
        for (String[] line : list) {
            Bill bill = new Bill(line);
            listBills.add(bill);
        }
        return listBills;
    }

    public void add(Bill bill) {
        List<Bill> list = new ArrayList<>();
        list.add(bill);
        funcReadAndWrite.writeFile("bill.csv", list, true);
    }

    public int calculateTotal(Customer customer, Bill bill) {
        if (customer instanceof Vietnamese) {
            int consumptionLimit = ((Vietnamese) customer).getConsumption();
            if (bill.getConsumption() <= consumptionLimit) {
                return bill.getConsumption() * bill.getPrice();
            } else {
                int overConsumption = bill.getConsumption() - consumptionLimit;
                return bill.getPrice() * (bill.getConsumption() + overConsumption * 5 / 2);
            }
        } else {
            return bill.getConsumption() * bill.getPrice();
        }
    }

    public void showAllBills() {
        List<Bill> list = findAllBills();
        int i = 1;
        for (Bill bill : list) {
            System.out.print(i + ". ");
            bill.showInfo();
            i++;
        }
    }

    public void showBillDetail(Bill bill) {
        Customer customer = new CustomerManager().findCustomerById(bill.getCustomerId());
        System.out.println("Bill{" +
                "billId='" + bill.getBillId() + '\'' +
                ", customerName='" + customer.getCustomerName() + '\'' +
                ", invoiceDate='" + bill.getInvoiceDate() + '\'' +
                ", consumption=" + bill.getConsumption() +
                ", price=" + bill.getPrice() +
                ", total=" + bill.getTotal() +
                '}');
    }

    public void edit(Bill newBill, String billId) {
        List<Bill> list = findAllBills();
        boolean check = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getBillId().equals(billId)) {
                list.remove(i);
                list.add(i, newBill);
                check = true;
                break;
            }
        }
        if (check) {
            funcReadAndWrite.writeFile("bill.csv", list, false);
        }
    }
}
