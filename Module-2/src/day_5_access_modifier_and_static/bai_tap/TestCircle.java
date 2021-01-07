package day_5_access_modifier_and_static.bai_tap;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        Circle c2 = new Circle(5);
        System.out.println("Ban kinh hinh tron c1: " + c1.getRadius());
        System.out.println("Dien tich hinh tron c1: " + c1.getArea());
        System.out.println("Ban kinh hinh tron c2: " + c2.getRadius());
        System.out.println("Dien tich hinh tron c2: " + c2.getArea());
    }
}
