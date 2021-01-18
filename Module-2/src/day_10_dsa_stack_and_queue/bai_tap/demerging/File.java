package day_10_dsa_stack_and_queue.bai_tap.demerging;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class File {
    private List<Employee> list = new ArrayList<>();

    public File() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            list.add(new Employee("Hoa", 'F', dateFormat.parse("01/01/2000")));
            list.add(new Employee("Quynh", 'F', dateFormat.parse("12/12/1999")));
            list.add(new Employee("Nghia", 'M', dateFormat.parse("14/10/1995")));
            list.add(new Employee("Vu", 'M', dateFormat.parse("05/03/2000")));
            list.add(new Employee("Nam", 'M', dateFormat.parse("31/07/1998")));
            list.add(new Employee("Ngan", 'F', dateFormat.parse("23/04/1999")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
    }

    public void printList() {
        for (Employee em : list) {
            System.out.println(em);
        }
    }

    public void demerging() {
        Queue<Employee> nu = new LinkedList<>();
        Queue<Employee> nam = new LinkedList<>();
        for (Employee em : list) {
            if (em.getGender() == 'F') {
                nu.add(em);
            } else {
                nam.add(em);
            }
        }
        list = new ArrayList<>();
        while (!nu.isEmpty()) {
            list.add(nu.remove());
        }
        while (!nam.isEmpty()) {
            list.add(nam.remove());
        }
    }

    public static void main(String[] args) {
        File file = new File();
        System.out.println("Raw file:");
        file.printList();
        file.demerging();
        System.out.println("File after demerging:");
        file.printList();
    }
}
