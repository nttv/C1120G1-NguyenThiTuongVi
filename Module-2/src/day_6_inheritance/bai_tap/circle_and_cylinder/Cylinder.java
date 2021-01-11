package day_6_inheritance.bai_tap.circle_and_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getVolume() {
        return getArea() * height;
    }

    @Override
    public String toString() {
        return "A Cylinder with height=" + height +
                ", is a subclass of " + super.toString() +
                ". It has volume=" + getVolume();
    }
}
