package FuramaResort.Services;

import FuramaResort.Commons.FuncReadAndWrite;
import FuramaResort.Models.Villa;

import java.util.ArrayList;
import java.util.List;

public class VillaManager extends Service<Villa> {
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
        Villa temp = findById(id);
        int index = listVilla.indexOf(temp);
        listVilla.remove(index);
        listVilla.add(index, villa);
        funcReadAndWrite.writeFile("Villa.csv", listVilla, false);
    }

    @Override
    public void remove(String id) {
        List<Villa> listVilla = findAll();
        Villa temp = findById(id);
        int index = listVilla.indexOf(temp);
        listVilla.remove(index);
        funcReadAndWrite.writeFile("Villa.csv", listVilla, false);
    }
}
