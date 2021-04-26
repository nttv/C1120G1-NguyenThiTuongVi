package com.furamavietnam.services.employee.impl;

import com.furamavietnam.models.AppUser;
import com.furamavietnam.models.Employee;
import com.furamavietnam.repositories.employee.EmployeeRepository;
import com.furamavietnam.services.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        repository.save(employee);
    }

    @Override
    public void delete(Integer id) {
        Employee employee = findById(id);
        employee.getAppUser().setEnabled(false);
        repository.deleteById(id);
    }

    @Override
    public Page<Employee> findAllByKey(String key, Pageable pageable) {
        return repository.findAllByKey(key, pageable);
    }

    @Override
    public Employee findByAppUser(AppUser appUser) {
        return repository.findByAppUser(appUser);
    }
}
