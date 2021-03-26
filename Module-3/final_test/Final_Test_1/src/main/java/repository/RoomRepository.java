package repository;

import model.Room;

import java.util.List;

public interface RoomRepository {
    List<Room> findAll();

    Room findById(int id);

    void save(Room room);

    void update(Room room);

    void remove(int id);

    List<Room> findByKey(String key);
}
