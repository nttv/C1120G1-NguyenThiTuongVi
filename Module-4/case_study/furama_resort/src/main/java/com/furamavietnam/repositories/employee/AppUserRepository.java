package com.furamavietnam.repositories.employee;

import com.furamavietnam.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, String> {
}
