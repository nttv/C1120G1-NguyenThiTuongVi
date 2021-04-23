package com.furamavietnam.services.customer.impl;

import com.furamavietnam.models.Customer;
import com.furamavietnam.repositories.customer.CustomerRepository;
import com.furamavietnam.services.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository repository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return repository.findAll(pageable);
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
}
