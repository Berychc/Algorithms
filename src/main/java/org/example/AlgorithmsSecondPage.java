package org.example;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AlgorithmsSecondPage {

    public void proveThat(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


    public int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public int fibonacciIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int fib = 0;
        int prev = 0;
        int current = 1;

        for (int i = 2; i <= n; i++) {
            fib = prev + current;
            prev = current;
            current = fib;
        }

        return fib;
    }

    // Объединение двух списков и затем объединить их
    public void mergeAndSortList() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(5);
        list1.add(2);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(6);

        List<Integer> mergeList = new ArrayList<>(list1);
        mergeList.addAll(list2);

        Collections.sort(mergeList);

        System.out.println(mergeList);
    }

    // Удалить дубликаты из отсортированного массива
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int count = 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != nums[count - 1]) { // проверка на дубликаты
                nums[count] = nums[i]; // сохраняем уникальный элемент
                count++;
            }
        }
        return count;
    }
}
