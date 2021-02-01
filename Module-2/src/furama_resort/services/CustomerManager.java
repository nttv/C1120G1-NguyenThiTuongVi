package furama_resort.services;

import furama_resort.commons.FuncReadAndWrite;
import furama_resort.models.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    static FuncReadAndWrite<Customer> funcReadAndWrite = new FuncReadAndWrite<>();

    public List<Customer> findAll() {
        List<String[]> list = funcReadAndWrite.readFile("Customer.csv");
        List<Customer> listCustomer = new ArrayList<>();
        for (String[] line : list) {
            Customer customer = new Customer(line);
            listCustomer.add(customer);
        }
        return listCustomer;
    }

    public void add(Customer customer) {
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        funcReadAndWrite.writeFile("Customer.csv", list, true);
    }
}
