package org.example.repositories;

import org.example.models.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> products;
    private static List<String> productTypes;

    static {
        products = new TreeMap<>();
        products.put(1, new Product(1, "iPhone 12", 1000, "Smartphone"));
        products.put(2, new Product(2, "Galaxy Tab A8", 250, "Tablet"));
        products.put(3, new Product(3, "All New Kindle", 120, "Kindle"));
        products.put(4, new Product(4, "iPad Air", 800, "Tablet"));
        products.put(5, new Product(5, "Oppo A12", 130, "Smartphone"));
        products.put(6, new Product(6, "Xiaomi Redmi", 160, "Smartphone"));
        products.put(7, new Product(7, "Matepad Pro", 850, "Tablet"));
        products.put(8, new Product(8, "Galaxy Note 20", 825, "Smartphone"));

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
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        List<Product> productList = findAll();
        int id = productList.get(productList.size() - 1).getId() + 1;
        product.setId(id);
        products.put(id, product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
