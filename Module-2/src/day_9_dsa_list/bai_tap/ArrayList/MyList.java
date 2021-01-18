package day_9_dsa_list.bai_tap.ArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0) {
            System.out.println("Index cannot be negative.");
        } else if (elements.length > size) {
            for (int i = size; i > index; i--) {
                elements[i] = elements[i - 1];
            }
            elements[index] = element;
            size++;
        } else {
            Object[] tempArray = elements;
            elements = new Object[size + 1];
            for (int i = 0; i < index; i++) {
                elements[i] = tempArray[i];
            }
            elements[index] = element;
            for (int i = index + 1; i < elements.length; i++) {
                elements[i] = tempArray[i - 1];
            }
            size++;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index from 0 to " + size);
        } else {
            Object element = elements[index];
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[size - 1] = null;
            size--;
            return (E) element;
        }
    }

    public int size() {
        return size;
    }

    public Object clone() {
        MyList<E> newList = new MyList<E>();
        newList.size = this.size;
        newList.elements = Arrays.copyOf(this.elements, this.size);
        return newList;
    }

    public boolean contains(E o) {
        if (this.indexOf(o) != -1) {
            return true;
        } else {
            return false;
        }
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        this.add(size, e);
        return true;
    }

    public void ensureCapacity(int minCapacity) {
        if (elements.length - size < minCapacity) {
            Object[] temp = elements;
            elements = new Object[size + minCapacity];
            int i = 0;
            while (temp[i] != null) {
                elements[i] = temp[i];
                i++;
            }
        }
    }

    public E get(int i) {
        return (E) elements[i];
    }

    public void clear() {
        size = 0;
        elements = new Object[DEFAULT_CAPACITY];
    }

    public static void main(String[] args) {
        MyList<Student> students = new MyList<Student>();
        students.add(new Student(1, "Vi", 20));
        students.add(new Student(2, "Dong", 20));
        students.add(new Student(3, "Van", 20));
        students.add(new Student(4, "Long", 20));
        students.add(new Student(5, "Nghia", 20));
        students.add(new Student(6, "Khoa", 20));
        students.ensureCapacity(10);
        System.out.println(students.elements.length);
    }
}
