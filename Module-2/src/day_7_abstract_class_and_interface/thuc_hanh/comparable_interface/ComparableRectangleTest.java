package day_7_abstract_class_and_interface.thuc_hanh.comparable_interface;

import java.util.Arrays;

public class ComparableRectangleTest {
    public static void main(String[] args) {
        ComparableRectangle[] rectangles = new ComparableRectangle[3];
        rectangles[0] = new ComparableRectangle(5, 10);
        rectangles[1] = new ComparableRectangle();
        rectangles[2] = new ComparableRectangle("indigo", false, 5, 5);

        System.out.println("Pre-sorted:");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }

        Arrays.sort(rectangles);

        System.out.println("After-sorted:");
        for (ComparableRectangle rectangle : rectangles) {
            System.out.println(rectangle);
        }
    }
}
