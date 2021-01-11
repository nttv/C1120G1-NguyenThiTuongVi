package day_7_abstract_class_and_interface.bai_tap.resizeable_interface;

import day_6_inheritance.thuc_hanh.Rectangle;

public class ResizeableRectangle extends Rectangle implements Resizeable {
    public ResizeableRectangle() {
    }

    public ResizeableRectangle(double width, double length) {
        super(width, length);
    }

    public ResizeableRectangle(String color, boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    @Override
    public String toString() {
        return "Rectangle{width=" + getWidth() + ", length=" + getLength() +
                ", area=" + getArea() + "}";
    }

    @Override
    public void resize(double percent) {
        setWidth(getWidth() * (1 + percent / 100));
        setLength(getLength() * (1 + percent / 100));
    }
}
