package service;

import model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    void remove(int id);

    Product findById(int id);

    List<Product> findByName(String name);
}
