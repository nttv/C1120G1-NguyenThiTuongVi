package services;

import commons.FuncReadAndWrite;
import models.Customer;
import models.Foreigner;
import models.Vietnamese;

import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    FuncReadAndWrite<Customer> funcReadAndWrite = new FuncReadAndWrite<>();

    public List<String[]> findAllCustomerType() {
        List<String[]> list = FuncReadAndWrite.readFile("customerType.csv");
        return list;
    }

    public void showAllCustomerType() {
        List<String[]> list = findAllCustomerType();
        int i = 1;
        for (String[] line : list) {
            System.out.println(i + ". " +
                    "id='" + line[0] + "'" +
                    ", type='" + line[1] + "'");
            i++;
        }
    }

    public List<Customer> findAllCustomers() {
        List<String[]> list = FuncReadAndWrite.readFile("customer.csv");
        List<Customer> listCustomers = new ArrayList<>();
        for (String[] line : list) {
            Customer customer;
            String signal = line[0].substring(2, 4);
            if (signal.equals("VN")) {
                customer = new Vietnamese(line);
            } else {
                customer = new Foreigner(line);
            }
            listCustomers.add(customer);
        }
        return listCustomers;
    }

    public Customer findCustomerById(String id) {
        List<Customer> list = findAllCustomers();
        for (Customer customer : list) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    public void showCustomers() {
        List<Customer> list = findAllCustomers();
        int i = 1;
        for (Customer customer : list) {
            System.out.print(i + ". ");
            customer.showInfo();
            i++;
        }
    }

    public void add(Customer customer) {
        List<Customer> list = new ArrayList<>();
        list.add(customer);
        funcReadAndWrite.writeFile("customer.csv", list, true);
    }

    public Customer findCustomerByName(String customerName) {
        List<Customer> list = findAllCustomers();
        for (Customer customer : list) {
            if (customer.getCustomerName().contains(customerName)) {
                return customer;
            }
        }
        return null;
    }
}
