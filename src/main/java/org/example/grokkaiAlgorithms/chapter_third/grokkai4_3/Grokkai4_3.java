package org.example.grokkaiAlgorithms.chapter_third.grokkai4_3;

import java.util.*;

public class Grokkai4_3 {
    /**
     * Найдите наибольшее число в списке
     */
    public static int max1(List<Integer> list) {
        if (list.isEmpty()) {
            throw new RuntimeException("List is empty");
        } else if (list.size() == 1) {
            return list.get(0);
        } else {
            int max = max1(list.subList(1, list.size()));
            return Math.max(list.get(0), max);
        }
    }

    public static int max2(List<Integer> list) {
        int max = list.get(0);
        for (Integer element : list) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 4, 1, 5);
        int result1 = Grokkai4_3.max1(list);
        int result2 = Grokkai4_3.max2(list);
        System.out.println(result1);
        System.out.println(result2);
    }
}
