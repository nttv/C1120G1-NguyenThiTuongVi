package day_6_inheritance.bai_tap.point2d_and_point3d;

public class Point3DTest {
    public static void main(String[] args) {
        Point3D point3D = new Point3D();
        System.out.println(point3D);

        point3D.setXYZ(3, 4, 5);
        float[] arr = point3D.getXYZ();
        for (float i : arr) {
            System.out.println(i);
        }

        point3D = new Point3D(5, 10, 20);
        System.out.println(point3D);
    }
}
