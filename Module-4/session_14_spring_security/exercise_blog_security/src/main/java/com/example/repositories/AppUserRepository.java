package com.example.repositories;

import com.example.models.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Repository
@Transactional
public class AppUserRepository {
    @Autowired
    private EntityManager entityManager;

    public AppUser findUserAccount(String username) {
        try {
            String sql = "Select e from " + AppUser.class.getName() + " e " //
                    + " Where e.username = :username ";

            Query query = entityManager.createQuery(sql, AppUser.class);
            query.setParameter("username", username);

            return (AppUser) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
}
