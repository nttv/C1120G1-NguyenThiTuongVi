package day_6_inheritance.bai_tap.point_and_moveablepoint;

public class PointTest {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);

        point.setXY(3, 4);
        float[] arr = point.getXY();
        for (float i : arr) {
            System.out.println(i);
        }

        point = new Point(5, 10);
        System.out.println(point);
    }
}
