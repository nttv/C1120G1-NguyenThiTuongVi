package day_7_abstract_class_and_interface.thuc_hanh.comparable_interface;

import day_6_inheritance.thuc_hanh.Rectangle;

public class ComparableRectangle extends Rectangle implements Comparable<ComparableRectangle> {
    public ComparableRectangle() {
    }

    public ComparableRectangle(double width, double length) {
        super(width, length);
    }

    public ComparableRectangle(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    @Override
    public int compareTo(ComparableRectangle obj) {
        if (getArea() > obj.getArea()) return 1;
        else if (getArea() < obj.getArea()) return -1;
        else return 0;
    }
}
