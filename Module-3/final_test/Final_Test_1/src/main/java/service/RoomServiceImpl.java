package service;

import model.Room;
import repository.RoomRepository;
import repository.RoomRepositoryImpl;
import service.RoomService;

import java.util.List;

public class RoomServiceImpl implements RoomService {
    private RoomRepository roomRepository = new RoomRepositoryImpl();


    @Override
    public List<Room> findAll() {
        return roomRepository.findAll();
    }

    @Override
    public Room findById(int id) {
        return roomRepository.findById(id);
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void remove(int id) {
        roomRepository.remove(id);
    }

    @Override
    public List<Room> findByKey(String key) {
        return roomRepository.findByKey(key);
    }
}
