package com.furamavietnam.services.customer.impl;

import com.furamavietnam.models.Customer;
import com.furamavietnam.repositories.customer.CustomerRepository;
import com.furamavietnam.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    public Customer findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public Page<Customer> findAllByKey(String key, Pageable pageable) {
        return repository.findAllByKey(key, pageable);
    }

    @Override
    public void validateExistingId(Customer customer, Errors errors) {
        Customer cus = findById(customer.getCustomerId());
        if (cus != null) {
            errors.rejectValue("customerId", "duplicate.customer.id");
        }
    }
}
