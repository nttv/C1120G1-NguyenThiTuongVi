package repository;

import model.Product;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "iPhone 12", 1500, "new", "Apple"));
        products.put(2, new Product(2, "Note 10", 1400, "new", "Samsung"));
        products.put(3, new Product(3, "iPhone XS Max", 1000, "new", "Apple"));
        products.put(4, new Product(4, "Oppo", 300, "old", "Oppo"));
        products.put(5, new Product(5, "Xiaomi", 500, "new", "Xiaomi"));
        products.put(6, new Product(6, "Huawei", 400, "old", "Huawei"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void update(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> list = new ArrayList<>();
        Set<Integer> keySet = products.keySet();
        for (int key : keySet) {
            if (products.get(key).getName().toLowerCase().contains(name.toLowerCase())) {
                list.add(products.get(key));
            }
        }
        return list;
    }
}
