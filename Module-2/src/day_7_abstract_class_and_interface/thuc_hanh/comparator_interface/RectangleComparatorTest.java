package day_7_abstract_class_and_interface.thuc_hanh.comparator_interface;

import day_6_inheritance.thuc_hanh.Rectangle;

import java.util.Arrays;
import java.util.Comparator;

public class RectangleComparatorTest {
    public static void main(String[] args) {
        Rectangle[] rectangles = new Rectangle[3];
        rectangles[0] = new Rectangle(5, 10);
        rectangles[1] = new Rectangle();
        rectangles[2] = new Rectangle("indigo", false, 5, 5);

        System.out.println("Pre-sorted:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Comparator rectangleComparator = new RectangleComparator();
        Arrays.sort(rectangles, rectangleComparator);

        System.out.println("After-sorted:");
        for (Rectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
