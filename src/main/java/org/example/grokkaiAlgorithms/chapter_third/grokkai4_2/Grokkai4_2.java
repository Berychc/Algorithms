package org.example.grokkaiAlgorithms.chapter_third.grokkai4_2;

import java.util.*;

public class Grokkai4_2 {

    /**
     * Напишите рекурсивную функцию для подсчета элементов в списке
     */
    public static int count1(List<Integer> list) {
        if (list.isEmpty()) {
            return 0;
        } else {
            return 1 + count1(list.subList(1, list.size()));
        }
    }

    public static int count2(List<Integer> list) {
        int count = 0;
        for (Integer element : list) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        int result1 = Grokkai4_2.count1(list);
        int result2 = Grokkai4_2.count2(list);
        System.out.println(result1);
        System.out.println(result2);
    }
}
