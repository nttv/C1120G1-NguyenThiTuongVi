package furama_resort.services;

import furama_resort.commons.FuncReadAndWrite;
import furama_resort.models.Villa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class VillaManager extends AdditionalService<Villa> {
    static FuncReadAndWrite<Villa> funcReadAndWrite = new FuncReadAndWrite<>();

    @Override
    public List<Villa> sortById() {
        return null;
    }

    @Override
    public List<Villa> findAll() {
        List<String[]> list = funcReadAndWrite.readFile("Villa.csv");
        List<Villa> listVilla = new ArrayList<>();
        for (String[] line : list) {
            Villa villa = new Villa(line);
            listVilla.add(villa);
        }
        return listVilla;
    }

    @Override
    public Villa findById(String id) {
        List<Villa> listVilla = findAll();
        for (Villa villa : listVilla) {
            if (villa.getServiceId().equals(id)) {
                return villa;
            }
        }
        return null;
    }

    @Override
    public void add(Villa villa) {
        List<Villa> list = new ArrayList<>();
        list.add(villa);
        funcReadAndWrite.writeFile("Villa.csv", list, true);
    }

    @Override
    public void edit(Villa villa, String id) {
        List<Villa> listVilla = findAll();
        int index = -1;
        for (int i = 0; i < listVilla.size(); i++) {
            if (listVilla.get(i).getServiceId().equals(id)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            listVilla.remove(index);
            listVilla.add(index, villa);
            funcReadAndWrite.writeFile("Villa.csv", listVilla, false);
        }
    }

    @Override
    public void remove(String id) {
        List<Villa> listVilla = findAll();
        Villa temp = findById(id);
        int index = listVilla.indexOf(temp);
        listVilla.remove(index);
        funcReadAndWrite.writeFile("Villa.csv", listVilla, false);
    }

    public Set<String> findAllName() {
        List<Villa> listVilla = findAll();
        Set<String> listNameVilla = new TreeSet<>();
        for (Villa villa : listVilla) {
            listNameVilla.add(villa.getServiceName());
        }
        return listNameVilla;
    }
}
