package repository;

import model.PaymentType;
import model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements RoomRepository {

    public static final String FIND_ALL_ROOMS = "select * from room";
    public static final String FIND_ROOM_BY_ID = "select * from room where room_id = ?";
    public static final String ADD_ROOM = "insert into room(tenant_name, phone, start_date, payment_type_id, note)" +
            " values(?,?,?,?,?)";
    public static final String UPDATE_ROOM = "update room set tenant_name = ?, phone = ?, start_date = ?," +
            " payment_type_id = ?, note = ? where room_id = ?";
    public static final String DELETE_ROOM = "delete from room where room_id = ?";
    public static final String FIND_BY_KEY = "select * from room where concat('PT-00', room_id) like concat('%', ?, '%')" +
            " or tenant_name like concat('%', ?, '%') or phone like concat('%', ?, '%')";

    private PaymentTypeRepository paymentTypeRepository = new PaymentTypeRepositoryImpl();

    @Override
    public List<Room> findAll() {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Room> roomList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_ALL_ROOMS);
                resultSet = statement.executeQuery();
                Room room;
                while (resultSet.next()) {
                    int roomId = resultSet.getInt(1);
                    String tenantName = resultSet.getString(2);
                    String phone = resultSet.getString(3);
                    Date startDate = resultSet.getDate(4);
                    PaymentType paymentType = paymentTypeRepository.findById(resultSet.getInt(5));
                    String note = resultSet.getString(6);
                    room = new Room(roomId, tenantName, phone, startDate, paymentType, note);
                    roomList.add(room);
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
        return roomList;
    }

    @Override
    public Room findById(int id) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Room room = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_ROOM_BY_ID);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int roomId = resultSet.getInt(1);
                    String tenantName = resultSet.getString(2);
                    String phone = resultSet.getString(3);
                    Date startDate = resultSet.getDate(4);
                    PaymentType paymentType = paymentTypeRepository.findById(resultSet.getInt(5));
                    String note = resultSet.getString(6);
                    room = new Room(roomId, tenantName, phone, startDate, paymentType, note);
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
        return room;
    }

    @Override
    public void save(Room room) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(ADD_ROOM);
                statement.setString(1, room.getTenantName());
                statement.setString(2, room.getPhone());
                statement.setDate(3, room.getStartDate());
                statement.setInt(4, room.getPaymentType().getPaymentTypeId());
                statement.setString(5, room.getNote());
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
    public void update(Room room) {

    }

    @Override
    public void remove(int id) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(DELETE_ROOM);
                statement.setInt(1, id);
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
    public List<Room> findByKey(String key) {
        Connection connection = DBConnection.open();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Room> roomList = new ArrayList<>();

        if (connection != null) {
            try {
                statement = connection.prepareStatement(FIND_BY_KEY);
                statement.setString(1, key);
                statement.setString(2, key);
                statement.setString(3, key);
                resultSet = statement.executeQuery();
                Room room = null;
                while (resultSet.next()) {
                    int roomId = resultSet.getInt(1);
                    String tenantName = resultSet.getString(2);
                    String phone = resultSet.getString(3);
                    Date startDate = resultSet.getDate(4);
                    PaymentType paymentType = paymentTypeRepository.findById(resultSet.getInt(5));
                    String note = resultSet.getString(6);
                    room = new Room(roomId, tenantName, phone, startDate, paymentType, note);
                    roomList.add(room);
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
        return roomList;
    }
}
