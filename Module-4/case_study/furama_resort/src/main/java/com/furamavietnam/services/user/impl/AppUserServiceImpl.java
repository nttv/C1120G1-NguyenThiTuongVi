package com.furamavietnam.services.user.impl;

import com.furamavietnam.models.AppUser;
import com.furamavietnam.repositories.user.AppUserRepository;
import com.furamavietnam.services.user.AppUserService;
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

    @Override
    public AppUser findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void save(AppUser appUser) {
        repository.save(appUser);
    }
}
