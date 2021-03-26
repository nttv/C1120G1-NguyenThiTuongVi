package repository;

import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {
    public static final String FIND_ALL_PRODUCTS = "select * from product";
    public static final String FIND_TOP_PRODUCTS = "select product.product_name, product.price, product.discount," +
            " product.stock, count(order_detail.product_id) as sold_quantity" +
            " from order_detail inner join `order` on order_detail.order_id = `order`.order_id" +
            " right join product on order_detail.product_id = product.product_id" +
            " group by product.product_id" +
            " order by sold_quantity desc" +
            " limit ?";
    public static final String ADD_PRODUCT = "insert into product(product_name, price, discount, stock) values(?,?,?,?)";
    public static final String FIND_PRODUCTS_IN_RANGE = "select product_name, price, discount, stock" +
            " from order_detail inner join `order` on order_detail.order_id = `order`.order_id" +
            " inner join product on order_detail.product_id = product.product_id" +
            " where `order`.order_date between ? and ?";

    @Override
    public List<Product> findAll() {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_ALL_PRODUCTS);
                resultSet = statement.executeQuery();
                Product product;
                while (resultSet.next()) {
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    int discount = resultSet.getInt(4);
                    int stock = resultSet.getInt(5);
                    product = new Product(name, price, discount, stock);
                    products.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return products;
    }

    @Override
    public void save(Product product) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(ADD_PRODUCT);
                statement.setString(1, product.getName());
                statement.setInt(2, product.getPrice());
                statement.setInt(3, product.getDiscount());
                statement.setInt(4, product.getStock());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<Product> findTop(int top) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_TOP_PRODUCTS);
                statement.setInt(1, top);
                resultSet = statement.executeQuery();
                Product product;
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    int price = resultSet.getInt(2);
                    int discount = resultSet.getInt(3);
                    int stock = resultSet.getInt(4);
                    product = new Product(name, price, discount, stock);
                    products.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return products;
    }

    @Override
    public List<Product> findInRange(Date startDate, Date endDate) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Product> products = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_PRODUCTS_IN_RANGE);
                statement.setDate(1, startDate);
                statement.setDate(2, endDate);
                resultSet = statement.executeQuery();
                Product product;
                while (resultSet.next()) {
                    String name = resultSet.getString(1);
                    int price = resultSet.getInt(2);
                    int discount = resultSet.getInt(3);
                    int stock = resultSet.getInt(4);
                    product = new Product(name, price, discount, stock);
                    products.add(product);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (resultSet != null) {
                        resultSet.close();
                    }
                    if (statement != null) {
                        statement.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return products;
    }
}
