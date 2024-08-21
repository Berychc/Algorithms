package org.example;

import org.example.entity.ListNode;

import java.util.*;

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

    // Объединение отсортированного списка
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        return dummy.next;
    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        if (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                list1.next = mergeTwoLists2(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists2(list1, list2.next);
                return list2;
            }
        }
        if (list1 == null)
            return list2;
        return list1;
    }


    // Допустимые скобки
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
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
