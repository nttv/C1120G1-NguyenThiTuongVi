package day_7_abstract_class_and_interface.bai_tap.resizeable_interface;

import day_6_inheritance.thuc_hanh.Shape;

public class Test {
    public static void main(String[] args) {
//        ResizeableCircle re = new ResizeableCircle(3.6);
//        System.out.println(re);
//        re.resize(20);
//        System.out.println("After-resized (increase 20%):");
//        System.out.println(re);

        Shape[] shapes = new Shape[3];
        shapes[0] = new ResizeableCircle(3.6);
        shapes[1] = new ResizeableRectangle(3, 5);
        shapes[2] = new ResizeableSquare(3.5);

        for (Shape shape : shapes) {
            System.out.println(shape);
            Resizeable resizeableShape;
            if (shape instanceof ResizeableCircle) {
                resizeableShape = (ResizeableCircle) shape;
            } else if (shape instanceof ResizeableRectangle) {
                resizeableShape = (ResizeableRectangle) shape;
            } else {
                resizeableShape = (ResizeableSquare) shape;
            }
            long percent = 1 + Math.round(99 * Math.random());
            resizeableShape.resize(percent);
            System.out.println("After-resized (increase " + percent + "%):");
            System.out.println(resizeableShape);
            System.out.println("=================");
        }
    }
}
