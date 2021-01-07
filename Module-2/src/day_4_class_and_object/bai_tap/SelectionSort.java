package day_4_class_and_object.bai_tap;

public class SelectionSort {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) Math.round(1000 * Math.random());  //moi phan tu nhan mot gia tri so nguyen random tu 0-1000
        }
        stopWatch.start();
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        stopWatch.stop();
        System.out.println("Thoi gian thuc thi cua thuat toan selection sort cho 100,000 số nguyên: "
                + stopWatch.getElapsedTime() + " milisecond");
    }
}