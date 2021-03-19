package repository;

import model.Customer;
import model.CustomerType;

import java.util.List;

public interface CustomerRepository {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);
}
