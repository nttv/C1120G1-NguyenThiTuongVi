package org.example.repositories;

import org.example.models.Product;

import java.util.List;

public interface ProductRepository {
    List<String> getProductTypeList();

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void remove(int id);
}
