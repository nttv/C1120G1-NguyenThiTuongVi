package com.furamavietnam.repositories.user;

import com.furamavietnam.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

    AppUser findByUsername(String username);

}
