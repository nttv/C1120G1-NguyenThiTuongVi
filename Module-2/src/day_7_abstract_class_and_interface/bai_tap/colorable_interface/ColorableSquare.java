package day_7_abstract_class_and_interface.bai_tap.colorable_interface;

import day_6_inheritance.thuc_hanh.Square;

public class ColorableSquare extends Square implements Colorable {
    public ColorableSquare() {
    }

    public ColorableSquare(double side) {
        super(side);
    }

    public ColorableSquare(String color, boolean filled, double side) {
        super(color, filled, side);
    }

    @Override
    public String toString() {
        return "Square{side=" + getSide() + ", area=" + getArea() + "}";
    }

    @Override
    public void howToColor() {
        System.out.println("\"Color all four sides\"");
    }
}
