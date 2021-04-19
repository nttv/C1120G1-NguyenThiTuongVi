package com.furamavietnam.services;

import com.furamavietnam.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    Customer findById(String id);

    void save(Customer customer);

    void delete(String id);

    Page<Customer> findAllByKey(String key, Pageable pageable);

}
