package repository;

import model.CustomerType;

import java.sql.*;

public class CustomerTypeRepositoryImpl implements CustomerTypeRepository {

    public static final String FIND_CUSTOMER_TYPE_BY_ID = "select * from customer_type where customer_type_id = ?";

    @Override
    public CustomerType findById(int id) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        CustomerType customerType = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_CUSTOMER_TYPE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int customerTypeId = resultSet.getInt(1);
                    String customerTypeName = resultSet.getString(2);
                    customerType = new CustomerType(customerTypeId, customerTypeName);
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
        return customerType;
    }
}
