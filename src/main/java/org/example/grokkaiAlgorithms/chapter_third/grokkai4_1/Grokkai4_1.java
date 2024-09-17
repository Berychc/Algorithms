package org.example.grokkaiAlgorithms.chapter_third.grokkai4_1;

import java.util.*;

public class Grokkai4_1 {

    /**
     * Код для функции sum
     */
    public static int sum1(int[] arr) {
        if (arr.length == 0) {
            return 0;
        } else {
            return arr[0] + sum1(Arrays.copyOfRange(arr, 1, arr.length));
        }
    }

    public static int sum2(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int result1 = Grokkai4_1.sum1(arr);
        int result2 = Grokkai4_1.sum2(arr);
        System.out.println(result1);
        System.out.println(result2);
    }
}
