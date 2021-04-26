package com.furamavietnam.services.employee;

import com.furamavietnam.models.AppUser;
import com.furamavietnam.models.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeService {

    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll();

    Employee findById(Integer id);

    void save(Employee employee);

    void delete(Integer id);

    Page<Employee> findAllByKey(String key, Pageable pageable);

    Employee findByAppUser(AppUser appUser);

}
