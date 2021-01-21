package day_13_sorting_algorithms.bai_tap;

import java.util.Scanner;

public class InsertionSortByStep {
    static int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter list size: ");
//        int size = scanner.nextInt();
//        int[] list = new int[size];
//        System.out.println("Enter " + list.length + " values:");
//        for (int i = 0; i < list.length; i++) {
//            list[i] = scanner.nextInt();
//        }
        System.out.print("Your input list: ");
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println("\nBegin sort processing...");
        insertionSortByStep(list);
    }

    public static void insertionSortByStep(int[] list) {
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int j;
            for (j = i - 1; j >= 0 && currentElement < list[j]; j--) {
                System.out.println("Move " + list[j] + " at index = " + j + " to index = " + (j + 1));
                list[j + 1] = list[j];
            }
            if (j == i - 1) {
                System.out.println(currentElement + " at index = " + (j + 1) + " has already been sorted");
            } else {
                System.out.println("Insert " + currentElement + " at index = " + (j + 1));
            }
            list[j + 1] = currentElement;
            System.out.print("List after the  " + i + "' sort: ");
            for (int k = 0; k < list.length; k++) {
                System.out.print(list[k] + "\t");
            }
            System.out.println();
        }
    }
}
