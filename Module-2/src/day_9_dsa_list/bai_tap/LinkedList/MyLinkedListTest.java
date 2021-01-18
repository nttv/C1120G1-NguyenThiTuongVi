package day_9_dsa_list.bai_tap.LinkedList;

import day_9_dsa_list.bai_tap.ArrayList.MyList;
import day_9_dsa_list.bai_tap.ArrayList.Student;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Student> students = new MyLinkedList<Student>();
        students.addFirst(new Student(1, "Vi", 20));
        students.addFirst(new Student(2, "Dong", 20));
        students.addLast(new Student(3, "Van", 20));
        students.addLast(new Student(4, "Long", 20));
        students.add(1, new Student(5, "Nghia", 20));
        students.add(3, new Student(6, "Khoa", 20));
        students.printList();

        System.out.println("---indexOf()---");
        Student s = new Student(5, "Nghia", 20);
        System.out.println(students.indexOf(s));

        System.out.println("---get()---");
        System.out.println(students.get(5));

        System.out.println("---remove()---");
        System.out.println(students.remove(3));
        System.out.println(students.remove(s));
        students.printList();

        System.out.println("---clone()---");
        MyLinkedList<Student> newList = (MyLinkedList) students.clone();
        newList.printList();

        System.out.println("---clear()---");
        students.clear();
        students.printList();
    }
}
