package services;

import commons.FuncReadAndWrite;
import models.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarManager implements IService<Car> {
    private static FuncReadAndWrite<Car> funcReadAndWrite = new FuncReadAndWrite<>();

    @Override
    public List<Car> findAll() {
        List<String[]> list = FuncReadAndWrite.readFile("oto.csv");
        List<Car> listCars = new ArrayList<>();
        for (String[] line : list) {
            Car car = new Car(line);
            listCars.add(car);
        }
        return listCars;
    }

    public void show() {
        List<String[]> list = FuncReadAndWrite.readFile("oto.csv");
        for (String[] line : list) {
            System.out.println(Arrays.toString(line));
        }
    }

    @Override
    public Car findById(String noPlate) {
        List<Car> list = findAll();
        for (Car car : list) {
            if (car.getNoPlate().equals(noPlate)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void add(Car car) {
        List<Car> list = new ArrayList<>();
        list.add(car);
        funcReadAndWrite.writeFile("oto.csv", list, true);
    }

    @Override
    public void edit(Car car, String noPlate) {
        List<Car> list = findAll();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNoPlate().equals(noPlate)) {
                list.remove(i);
                list.add(i, car);
                funcReadAndWrite.writeFile("oto.csv", list, false);
                return;
            }
        }
    }

    @Override
    public void delete(String noPlate) {
        List<Car> list = findAll();
        for (Car car : list) {
            if (car.getNoPlate().equals(noPlate)) {
                list.remove(car);
                funcReadAndWrite.writeFile("oto.csv", list, false);
                return;
            }
        }
    }
}
