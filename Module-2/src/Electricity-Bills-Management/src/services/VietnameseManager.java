package services;

import commons.FuncReadAndWrite;
import models.Vietnamese;

import java.util.ArrayList;
import java.util.List;

public class VietnameseManager {
    FuncReadAndWrite<Vietnamese> funcReadAndWrite = new FuncReadAndWrite<>();

    public void add(Vietnamese vietnamese) {
        List<Vietnamese> list = new ArrayList<>();
        list.add(vietnamese);
        funcReadAndWrite.writeFile("customer.csv", list, true);
    }
}
