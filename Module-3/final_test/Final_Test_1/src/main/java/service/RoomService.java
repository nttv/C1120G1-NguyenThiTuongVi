package service;

import model.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAll();

    Room findById(int id);

    void save(Room room);

    void remove(int id);

    List<Room> findByKey(String key);
}
