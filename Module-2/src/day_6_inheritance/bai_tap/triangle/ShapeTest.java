package day_6_inheritance.bai_tap.triangle;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();
        shape.setColor("Orange");
        System.out.println(shape);

        shape = new Shape("Red");
        System.out.println(shape);
    }
}
