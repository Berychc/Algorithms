package org.example.grokkaiAlgorithms.chapter_third.grokkai4_4;

public class Grokkai4_4 {
    /**
     * Помните бинарный поиск он тоже относится к классу алгоритмов "разделяй и властвуй"
     * сможете ли вы определить базовый и Рекурсивный случай для бинарного поиска
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int midpoint = left + (right - left) / 2;

            if (arr[midpoint] == target) {
                return midpoint;
            } else if (arr[midpoint] < target) {
                left = midpoint + 1;
            } else {
                right = midpoint - 1;
            }
        }

        return -1; // not found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 7;

        int result = Grokkai4_4.binarySearch(arr, target);

        if (result != -1) {
            System.out.println("Element found at index " + result);
        } else {
            System.out.println("Element not found");
        }
    }
}
