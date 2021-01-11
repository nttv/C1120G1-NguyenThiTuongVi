package day_7_abstract_class_and_interface.bai_tap.resizeable_interface;

import day_6_inheritance.thuc_hanh.Circle;

public class ResizeableCircle extends Circle implements Resizeable {
    public ResizeableCircle() {
    }

    public ResizeableCircle(double radius) {
        super(radius);
    }

    public ResizeableCircle(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public String toString() {
        return "Circle{radius=" + getRadius() + ", area=" + getArea() + "}";
    }

    @Override
    public void resize(double percent) {
        setRadius(getRadius() * (1 + percent / 100));
    }
}
