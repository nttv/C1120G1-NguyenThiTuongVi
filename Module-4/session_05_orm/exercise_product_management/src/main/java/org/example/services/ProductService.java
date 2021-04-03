package org.example.services;

import org.example.models.Product;

import java.util.List;

public interface ProductService {
    List<String> getProductTypeList();

    List<Product> findAll();

    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void remove(int id);
}
