package repository;

import model.PaymentType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentTypeRepositoryImpl implements PaymentTypeRepository {

    public static final String FIND_ALL_PAYMENT_TYPES = "select * from payment_type";
    public static final String FIND_PAYMENT_TYPE_BY_ID = "select * from payment_type where payment_type_id = ?";

    @Override
    public List<PaymentType> findAll() {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<PaymentType> paymentTypeList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_ALL_PAYMENT_TYPES);
                resultSet = statement.executeQuery();
                PaymentType paymentType;
                while (resultSet.next()) {
                    int paymentTypeId = resultSet.getInt(1);
                    String paymentTypeName = resultSet.getString(2);
                    paymentType = new PaymentType(paymentTypeId, paymentTypeName);
                    paymentTypeList.add(paymentType);
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
        return paymentTypeList;
    }

    @Override
    public PaymentType findById(int id) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        PaymentType paymentType = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_PAYMENT_TYPE_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int paymentTypeId = resultSet.getInt(1);
                    String paymentTypeName = resultSet.getString(2);
                    paymentType = new PaymentType(paymentTypeId, paymentTypeName);
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
        return paymentType;
    }
}
