package services;

import commons.FuncReadAndWrite;
import models.House;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HouseManager implements CRUDService<House> {
    static FuncReadAndWrite<House> funcReadAndWrite = new FuncReadAndWrite<>();

    @Override
    public List<House> findAll() {
        List<String[]> list = funcReadAndWrite.readFile("House.csv");
        List<House> listHouse = new ArrayList<>();
        for (String[] line : list) {
            House house = new House(line);
            listHouse.add(house);
        }
        return listHouse;
    }

    @Override
    public House findById(String id) {
        List<House> listHouse = findAll();
        for (House house : listHouse) {
            if (house.getServiceId().equals(id)) {
                return house;
            }
        }
        return null;
    }

    @Override
    public void add(House house) {
        List<House> list = new ArrayList<>();
        list.add(house);
        funcReadAndWrite.writeFile("House.csv", list, true);
    }

    @Override
    public void edit(House house, String id) {
        List<House> listHouse = findAll();
        for (int i = 0; i < listHouse.size(); i++) {
            if (listHouse.get(i).getServiceId().equals(id)) {
                listHouse.remove(i);
                listHouse.add(i, house);
                funcReadAndWrite.writeFile("House.csv", listHouse, false);
                return;
            }
        }
    }

    @Override
    public void remove(String id) {
        List<House> listHouse = findAll();
        for (House house : listHouse) {
            if (house.getServiceId().equals(id)) {
                listHouse.remove(house);
                funcReadAndWrite.writeFile("House.csv", listHouse, false);
                return;
            }
        }
    }

    public Set<String> findAllName() {
        List<House> listHouse = findAll();
        Set<String> listNameHouse = new TreeSet<>();
        for (House house : listHouse) {
            listNameHouse.add(house.getServiceName());
        }
        return listNameHouse;
    }
}
