package com.furamavietnam.services.employee.impl;

import com.furamavietnam.models.AppUser;
import com.furamavietnam.repositories.employee.AppUserRepository;
import com.furamavietnam.services.employee.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository repository;

    @Override
    public List<AppUser> findAll() {
        return repository.findAll();
    }
}
