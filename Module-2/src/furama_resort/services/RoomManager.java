package furama_resort.services;

import furama_resort.commons.FuncReadAndWrite;
import furama_resort.models.Room;
import furama_resort.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class RoomManager implements CRUDService<Room> {
    static FuncReadAndWrite<Room> funcReadAndWrite = new FuncReadAndWrite<>();

    @Override
    public List<Room> findAll() {
        List<String[]> list = funcReadAndWrite.readFile("Room.csv");
        List<Room> listRoom = new ArrayList<>();
        for (String[] line : list) {
            Room room = new Room(line);
            listRoom.add(room);
        }
        return listRoom;
    }

    @Override
    public Room findById(String id) {
        List<Room> listRoom = findAll();
        for (Room room : listRoom) {
            if (room.getServiceId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    @Override
    public void add(Room room) {
        List<Room> list = new ArrayList<>();
        list.add(room);
        funcReadAndWrite.writeFile("Room.csv", list, true);
    }

    @Override
    public void edit(Room room, String id) {
        List<Room> listRoom = findAll();
        for (int i = 0; i < listRoom.size(); i++) {
            if (listRoom.get(i).getServiceId().equals(id)) {
                listRoom.remove(i);
                listRoom.add(i, room);
                funcReadAndWrite.writeFile("Room.csv", listRoom, false);
                return;
            }
        }
    }

    @Override
    public void remove(String id) {
        List<Room> listRoom = findAll();
        for (Room room : listRoom) {
            if (room.getServiceId().equals(id)) {
                listRoom.remove(room);
                funcReadAndWrite.writeFile("Room.csv", listRoom, false);
                return;
            }
        }
    }

    public Set<String> findAllName() {
        List<Room> listRoom = findAll();
        Set<String> listNameRoom = new TreeSet<>();
        for (Room room : listRoom) {
            listNameRoom.add(room.getServiceName());
        }
        return listNameRoom;
    }
}
