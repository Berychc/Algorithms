package org.example.aglorithms;

import org.example.aglorithms.entity.ListNode;

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
    public int[] deleteDuplicates(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Пустой массив");
        }
        Arrays.sort(array); // сортировка списка
        int count = 1; // счетчик уникальных элементов

        for (int i = 1; i < array.length; i++) { // начало с 1
            if (array[i] != array[count - 1]) { // проверка дубликатов
                array[count] = array[i];
                count++;
            }
        }
        return Arrays.copyOf(array, count); // Возвращаем новый массив с уникальными элементами
    }

    // удалить дубликаты листа
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }

        ListNode current = head;
        while(current.next != null) {
            if(current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }


    public int[] twoSum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int numberToFind = k - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == numberToFind) {
                return new int[] {nums[i], nums[mid]};
                }
                if (numberToFind < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return new int[0];
    }

    // Удаление дубликатов в строке
    static String removeDuplicatiesString(String s) {
        if (s.isEmpty()) {
            throw new NullPointerException("Пустая строка");
        }

        HashSet<Character> seen = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (seen.add(c)) {
                result.append(c);
            }
        }
        return result.toString();
    }


    // Объединение двух строк в двоичный файл
    static String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();

        int result = 0, readerA = charsA.length - 1, readerB = charsB.length - 1;
        StringBuilder sb = new StringBuilder();

        while (readerA >= 0 && readerB >= 0) {
            int aa = charsA[readerA] - '0', bb = charsB[readerB] - '0', sum = aa + bb + result;
            result = sum / 2;
            sb.append(sum % 2);

            readerA--;
            readerB--;
        }

        while (readerA >= 0) {
            int aa = charsA[readerA] - '0';
            int sum = aa + result;
            result = sum / 2;
            sb.append(sum % 2);
            readerA--;
        }

        while (readerB >= 0) {
            int bb = charsB[readerB] - '0';
            int sum = bb + result;
            result = sum / 2;
            sb.append(sum % 2);
            readerB--;
        }

        if (result != 0) {
            sb.append(result);
        }

        return sb.reverse().toString();
    }
}
