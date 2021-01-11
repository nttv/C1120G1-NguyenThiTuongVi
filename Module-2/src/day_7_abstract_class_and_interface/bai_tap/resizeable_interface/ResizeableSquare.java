package day_7_abstract_class_and_interface.bai_tap.resizeable_interface;

import day_6_inheritance.thuc_hanh.Square;

public class ResizeableSquare extends Square implements Resizeable {
    public ResizeableSquare() {
    }

    public ResizeableSquare(double side) {
        super(side);
    }

    public ResizeableSquare(String color, boolean filled, double side) {
        super(color, filled, side);
    }

    @Override
    public String toString() {
        return "Square{side=" + getSide() + ", area=" + getArea() + "}";
    }

    @Override
    public void resize(double percent) {
        setSide(getSide() * (1 + percent / 100));
    }
}
