package org.example.services;

import org.example.models.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();

    Customer findById(int id);

    void save(Customer customer);

    void update(Customer customer);

    void remove(int id);
}
