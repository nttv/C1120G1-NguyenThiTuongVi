package day_6_inheritance.bai_tap.circle_and_cylinder;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.setColor("green");
        circle.setRadius(3);
        System.out.println(circle);

        circle = new Circle(3.5, "indigo");
        System.out.println(circle);
    }
}
