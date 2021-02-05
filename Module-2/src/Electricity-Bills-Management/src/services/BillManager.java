package services;

import commons.FuncReadAndWrite;
import models.Bill;
import models.Customer;
import models.Foreigner;
import models.Vietnamese;

import java.util.ArrayList;
import java.util.List;

public class BillManager {
    FuncReadAndWrite<Bill> funcReadAndWrite = new FuncReadAndWrite<>();

    public void add(Bill bill) {
        List<Bill> list = new ArrayList<>();
        list.add(bill);
        funcReadAndWrite.writeFile("bill.csv", list, true);
    }

    public double calculateTotal(Customer customer, Bill bill) {
        if (customer instanceof Vietnamese) {
            int consumptionLimit = ((Vietnamese) customer).getConsumption();
            if (bill.getConsumption() <= consumptionLimit) {
                return bill.getConsumption() * bill.getPrice();
            } else {
                int overConsumption = bill.getConsumption() - consumptionLimit;
                return bill.getPrice() * (bill.getConsumption() + overConsumption * 2.5);
            }
        } else {
            return bill.getConsumption() * bill.getPrice();
        }
    }
}
