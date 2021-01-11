package day_6_inheritance.bai_tap.point2d_and_point3d;

public class Point2DTest {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println(point2D);

        point2D.setXY(3, 4);
        float[] arr = point2D.getXY();
        for (float i : arr) {
            System.out.println(i);
        }

        point2D = new Point2D(5, 10);
        System.out.println(point2D);
    }
}
