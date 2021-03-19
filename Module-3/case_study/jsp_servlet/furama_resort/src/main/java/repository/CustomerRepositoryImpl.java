package repository;

import model.Customer;
import model.CustomerType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements CustomerRepository {

    public static final String QUERY_ADD_CUSTOMER = "insert into customer(customer_type_id,customer_name,customer_birthday," +
            "customer_gender,customer_id_card,customer_phone,customer_email,customer_address) values(?,?,?,?,?,?,?,?)";
    public static final String FIND_ALL_CUSTOMERS = "select * from customer";
    public static final String FIND_CUSTOMER_BY_ID = "select * from customer where customer_id = ?";

    private CustomerTypeRepository customerTypeRepository = new CustomerTypeRepositoryImpl();

    @Override
    public List<Customer> findAll() {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_ALL_CUSTOMERS);
                resultSet = statement.executeQuery();
                Customer customer;
                while (resultSet.next()) {
                    int customerId = resultSet.getInt(1);
                    CustomerType customerType = customerTypeRepository.findById(resultSet.getInt(2));
                    String customerName = resultSet.getString(3);
                    Date customerBirthday = resultSet.getDate(4);
                    boolean customerGender = resultSet.getBoolean(5);
                    String customerIdCard = resultSet.getString(6);
                    String customerPhone = resultSet.getString(7);
                    String customerEmail = resultSet.getString(8);
                    String customerAddress = resultSet.getString(9);
                    customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender,
                            customerIdCard, customerPhone, customerEmail, customerAddress);
                    customerList.add(customer);
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
        return customerList;
    }

    @Override
    public Customer findById(int id) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Customer customer = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_CUSTOMER_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int customerId = resultSet.getInt(1);
                    CustomerType customerType = customerTypeRepository.findById(resultSet.getInt(2));
                    String customerName = resultSet.getString(3);
                    Date customerBirthday = resultSet.getDate(4);
                    boolean customerGender = resultSet.getBoolean(5);
                    String customerIdCard = resultSet.getString(6);
                    String customerPhone = resultSet.getString(7);
                    String customerEmail = resultSet.getString(8);
                    String customerAddress = resultSet.getString(9);
                    customer = new Customer(customerId, customerType, customerName, customerBirthday, customerGender,
                            customerIdCard, customerPhone, customerEmail, customerAddress);
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
        return customer;
    }

    @Override
    public void save(Customer customer) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(QUERY_ADD_CUSTOMER);
                statement.setInt(1, customer.getCustomerType().getCustomerTypeId());
                statement.setString(2, customer.getCustomerName());
                statement.setDate(3, customer.getCustomerBirthday());
                statement.setBoolean(4, customer.isCustomerGender());
                statement.setString(5, customer.getCustomerIdCard());
                statement.setString(6, customer.getCustomerPhone());
                statement.setString(7, customer.getCustomerEmail());
                statement.setString(8, customer.getCustomerAddress());
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
}
