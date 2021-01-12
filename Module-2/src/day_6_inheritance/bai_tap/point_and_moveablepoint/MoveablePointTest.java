package day_6_inheritance.bai_tap.point_and_moveablepoint;

public class MoveablePointTest {
    public static void main(String[] args) {
        MoveablePoint mp = new MoveablePoint();
        System.out.println(mp);

        mp = new MoveablePoint(10, 20);
        System.out.println(mp);

        mp = new MoveablePoint(2, 4, 10, 15);
        System.out.println(mp);

        mp = mp.move();
        System.out.println(mp);
    }
}