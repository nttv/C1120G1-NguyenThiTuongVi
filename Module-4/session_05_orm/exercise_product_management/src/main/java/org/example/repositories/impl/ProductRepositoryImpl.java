package org.example.repositories.impl;

import org.example.models.Product;
import org.example.repositories.ProductRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Transactional
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager em;

    private static List<String> productTypes;

    static {
        productTypes = new ArrayList<>();
        productTypes.add("Smartphone");
        productTypes.add("Tablet");
        productTypes.add("Kindle");
    }

    @Override
    public List<String> getProductTypeList() {
        return productTypes;
    }

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> query = em.createQuery("select p from Product p", Product.class);
        return query.getResultList();
    }

    @Override
    public Product findById(int id) {
        TypedQuery<Product> query = em.createQuery("select p from Product p where p.id=:id", Product.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void save(Product product) {
        em.persist(product);
    }

    @Override
    public void update(Product product) {
        em.merge(product);
    }

    @Override
    public void remove(int id) {
        em.remove(findById(id));
    }
}
