package day_7_abstract_class_and_interface.thuc_hanh.comparable_interface;

import day_6_inheritance.thuc_hanh.Circle;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle obj) {
        if (getRadius() > obj.getRadius()) return 1;
        else if (getRadius() < obj.getRadius()) return -1;
        else return 0;
    }
}
