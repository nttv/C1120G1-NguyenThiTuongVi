package day_9_dsa_list.bai_tap.ArrayList;

import java.util.ArrayList;
import java.util.Arrays;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Student> students = new MyList<Student>();
        students.add(new Student(1, "Vi", 20));
        students.add(new Student(2, "Dong", 20));
        students.add(new Student(3, "Van", 20));
        students.add(new Student(4, "Long", 20));
        students.add(new Student(5, "Nghia", 20));
        students.add(new Student(6, "Khoa", 20));
        System.out.println("---indexOf()---");
        Student s = new Student(5, "Nghia", 20);
        System.out.println(students.indexOf(s));
        System.out.println("---get()---");
        System.out.println(students.get(5));
        System.out.println("---clone()---");
        MyList<Student> newList = (MyList) students.clone();
        for (int i = 0; i < newList.size(); i++) {
            System.out.println(newList.get(i));
        }
        System.out.println("---clear()---");
        students.clear();
        System.out.println(students.get(0));
    }
}
