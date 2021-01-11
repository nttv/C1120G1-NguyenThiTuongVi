package day_7_abstract_class_and_interface.bai_tap.colorable_interface;

import day_6_inheritance.thuc_hanh.Shape;
import day_7_abstract_class_and_interface.bai_tap.resizeable_interface.ResizeableCircle;
import day_7_abstract_class_and_interface.bai_tap.resizeable_interface.ResizeableRectangle;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        shapes[0] = new ResizeableRectangle(4, 5);
        shapes[1] = new ColorableSquare(6);
        shapes[2] = new ResizeableCircle(4.5);
        shapes[3] = new ColorableSquare(3);
        for (Shape shape : shapes) {
            System.out.println(shape);
            if (shape instanceof ColorableSquare) {
                ((ColorableSquare) shape).howToColor();
            }
        }
    }
}
