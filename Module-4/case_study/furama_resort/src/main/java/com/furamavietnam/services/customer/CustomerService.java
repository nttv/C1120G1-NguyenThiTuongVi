package com.furamavietnam.services.customer;

import com.furamavietnam.models.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;

import java.util.List;

public interface CustomerService {

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    Customer findById(String id);

    void save(Customer customer);

    void delete(String id);

    Page<Customer> findAllByKey(String key, Pageable pageable);

    void validateExistingId(Customer customer, Errors errors);

}
