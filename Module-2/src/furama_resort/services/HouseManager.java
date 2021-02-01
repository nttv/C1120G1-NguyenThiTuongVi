package furama_resort.services;

import furama_resort.commons.FuncReadAndWrite;
import furama_resort.models.House;
import furama_resort.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HouseManager extends AdditionalService<House> {
    static FuncReadAndWrite<House> funcReadAndWrite = new FuncReadAndWrite<>();

    @Override
    public List<House> sortById() {
        return null;
    }

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
        House temp = findById(id);
        int index = listHouse.indexOf(temp);
        listHouse.remove(index);
        listHouse.add(index, house);
        funcReadAndWrite.writeFile("House.csv", listHouse, false);
    }

    @Override
    public void remove(String id) {
        List<House> listHouse = findAll();
        House temp = findById(id);
        int index = listHouse.indexOf(temp);
        listHouse.remove(index);
        funcReadAndWrite.writeFile("House.csv", listHouse, false);
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
