package com.furamavietnam.repositories.user;

import com.furamavietnam.models.AppUser;
import com.furamavietnam.models.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findAllByAppUser(AppUser appUser);

}
