package repository;

import model.User;

import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    public static final String FIND_ALL_USERS = "call find_all_users()";
    public static final String INSERT_NEW_USER = "call insert_user(?, ?, ?)";
    public static final String FIND_BY_ID = "call find_by_id(?)";
    public static final String UPDATE_USER = "call update_user(?, ?, ?, ?)";
    public static final String DELETE_USER = "call delete_user(?)";
    public static final String FIND_BY_COUNTRY = "select * from users where country like concat('%',?,'%')";
    public static final String ASSIGN_PERMISSIONS = "insert into user_permission(permission_id, user_id) values(?, ?)";
    private static final String SQL_INSERT = "INSERT INTO EMPLOYEE (NAME, SALARY, CREATED_DATE) VALUES (?,?,?)";
    private static final String SQL_UPDATE = "UPDATE EMPLOYEE SET SALARY=? WHERE NAME=?";
    private static final String SQL_TABLE_CREATE = "CREATE TABLE EMPLOYEE"
            + "("
            + " ID serial,"
            + " NAME varchar(100) NOT NULL,"
            + " SALARY numeric(15, 2) NOT NULL,"
            + " CREATED_DATE timestamp,"
            + " PRIMARY KEY (ID)"
            + ")";
    private static final String SQL_TABLE_DROP = "DROP TABLE IF EXISTS EMPLOYEE";

    @Override
    public List<User> findAll() {
        Connection connection = DBConnection.open();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareCall(FIND_ALL_USERS);
                resultSet = statement.executeQuery();

                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return users;
    }

    @Override
    public User findById(int id) {
        Connection connection = DBConnection.open();
        CallableStatement statement = null;
        ResultSet resultSet = null;
        User user = null;

        if (connection != null) {
            try {
                statement = connection.prepareCall(FIND_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    String country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return user;
    }

    @Override
    public void save(User user) {
        Connection connection = DBConnection.open();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(INSERT_NEW_USER);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void update(User user) {
        Connection connection = DBConnection.open();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(UPDATE_USER);
                statement.setInt(1, user.getId());
                statement.setString(2, user.getName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getCountry());
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.open();
        CallableStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareCall(DELETE_USER);
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public List<User> findByCountry(String country) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_BY_COUNTRY);
                statement.setString(1, country);
                resultSet = statement.executeQuery();
                User user = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String email = resultSet.getString("email");
                    country = resultSet.getString("country");
                    user = new User(id, name, email, country);
                    users.add(user);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
        return users;
    }

    @Override
    public void addUserTransaction(User user, int[] permissions) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        if (connection != null) {
            try {
                connection.setAutoCommit(false);
                statement = connection.prepareStatement(INSERT_NEW_USER, Statement.RETURN_GENERATED_KEYS);
                statement.setString(1, user.getName());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getCountry());
                int rowAffected = statement.executeUpdate();
                resultSet = statement.getGeneratedKeys();
                int userId = 0;
                if (resultSet.next()) {
                    userId = resultSet.getInt(1);
                }
                if (rowAffected == 1) {
                    statement = connection.prepareStatement(ASSIGN_PERMISSIONS);
                    for (int permissionId : permissions) {
                        statement.setInt(1, permissionId);
                        statement.setInt(2, userId);
                        statement.executeUpdate();
                    }
                    connection.commit();
                } else {
                    connection.rollback();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                DBConnection.close();
            }
        }
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        try (Connection connection = DBConnection.open();
             Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            // Run list of update commands
            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
            psUpdate.setBigDecimal(2, new BigDecimal(999.99));

            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertUpdateUseTransaction() {
        try (Connection connection = DBConnection.open();
             Statement statement = connection.createStatement();
             PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT);
             PreparedStatement psUpdate = connection.prepareStatement(SQL_UPDATE)) {
            statement.execute(SQL_TABLE_DROP);
            statement.execute(SQL_TABLE_CREATE);

            // start transaction block
            connection.setAutoCommit(false); // default true

            // Run list of insert commands
            psInsert.setString(1, "Quynh");
            psInsert.setBigDecimal(2, new BigDecimal(10));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            psInsert.setString(1, "Ngan");
            psInsert.setBigDecimal(2, new BigDecimal(20));
            psInsert.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            psInsert.execute();

            // Run list of update commands
            // below line caused error, test transaction
            // org.postgresql.util.PSQLException: No value specified for parameter 1.
//            psUpdate.setBigDecimal(2, new BigDecimal(999.99));
            psUpdate.setBigDecimal(1, new BigDecimal(999.99));

            //psUpdate.setBigDecimal(1, new BigDecimal(999.99));
            psUpdate.setString(2, "Quynh");
            psUpdate.execute();

            // end transaction block, commit changes
            connection.commit();

            // good practice to set it back to default true
            connection.setAutoCommit(true);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
