package com.furamavietnam.services.user;

import com.furamavietnam.models.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> findAll();

    AppUser findByUsername(String username);

    void save(AppUser appUser);

}
