package org.example.services;

import org.example.models.Product;

import java.util.List;

public interface ProductService {
    List<String> getProductTypeList();

    List<Product> findAll();

    void save(Product product);

    Product findById(int id);

    void update(Product product);

    void remove(int id);
}
