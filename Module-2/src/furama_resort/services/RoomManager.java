package furama_resort.services;

import furama_resort.commons.FuncReadAndWrite;
import furama_resort.models.Room;

import java.util.ArrayList;
import java.util.List;

public class RoomManager extends AdditionalService<Room> {
    static FuncReadAndWrite<Room> funcReadAndWrite = new FuncReadAndWrite<>();

    @Override
    public List<Room> sortById() {
        return null;
    }

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
        Room temp = findById(id);
        int index = listRoom.indexOf(temp);
        listRoom.remove(index);
        listRoom.add(index, room);
        funcReadAndWrite.writeFile("Room.csv", listRoom, false);
    }

    @Override
    public void remove(String id) {
        List<Room> listRoom = findAll();
        Room temp = findById(id);
        int index = listRoom.indexOf(temp);
        listRoom.remove(index);
        funcReadAndWrite.writeFile("Room.csv", listRoom, false);
    }
}
