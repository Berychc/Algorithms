package org.example.grokkaiAlgorithms;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class GrokkaiAlgorithms {

    public static int sum(int[] arr) {
        int total = 0;
        for (int x : arr) {
            total += x;
        }
        return total;
    }


    /**
     * Сортировка массива по возрастанию
     */
    public static int findSmallest(int[] arr) {
        int smallest = arr[0];
        int smallestIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smallest) {
                smallest = arr[i];
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }

    /**
     * Сортировка выбором
     */
    public static List<Integer> selectionSort(int[] arr) {
        List<Integer> newArr = new ArrayList<>();
        while (!isEmpty(arr)) {
            int smallestIndex = findSmallest(arr);
            newArr.add(arr[smallestIndex]);
            arr = removeElement(arr, smallestIndex);
        }
        return newArr;
    }

    private static boolean isEmpty(int[] arr) {
        return arr.length == 0;
    }

    private static int[] removeElement(int[] arr, int index) {
        int[] newArr = new int[arr.length - 1];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j] = arr[i];
                j++;
            }
        }
        return newArr;
    }

    /**
     * Быстрая сортировка
     */
    public static int[] quicksort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            int pivot = array[0];
            int[] less = getLess(array, pivot);
            int[] greater = getGreater(array, pivot);
            return concatenate(quicksort(less), new int[]{pivot}, quicksort(greater));
        }
    }

    private static int[] getLess(int[] array, int pivot) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i] < pivot) {
                result.add(array[i]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int[] getGreater(int[] array, int pivot) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < array.length; i++) {
            if (array[i] > pivot) {
                result.add(array[i]);
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private static int[] concatenate(int[] a, int[] b, int[] c) {
        int[] result = new int[a.length + b.length + c.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        System.arraycopy(c, 0, result, a.length + b.length, c.length);
        return result;
    }

    /**
     * Функция для вывода каждого элемента в списке
     */
    public static void printItems(List<Integer> list) {
        for (Integer item : list) {
            System.out.println(item);
        }
    }

    /**
     * Функция перебирает все элементы списка и выводит их
     */
    public static void printItems2(List<Integer> list) {
        for (Integer item : list) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            System.out.println(item);
        }
    }

    /**
     * Примеры вывода каждого элемента массива
     */
    public static void example() {
        int[] array = {1, 2, 3, 4, 5};
        for (int item : array) {
            System.out.println(item);
        }

        int[] array1 = {1, 2, 3, 4, 5};
        for (int i = 0; i < array1.length; i++) {
            System.out.println(array1[i]);
        }
    }

    /**
     * Удвоение значения каждого элемента массива
     */
    public static void example2() {
        int[] array = {1, 2, 3, 4, 5};
        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
        System.out.println(Arrays.toString(array));


        int[] array1 = {1, 2, 3, 4, 5};
        int[] doubledArray = new int[array1.length];
        for (int i = 0; i < array1.length; i++) {
            doubledArray[i] = array1[i] * 2;
        }
        System.out.println(Arrays.toString(doubledArray));
    }

    /**
     * Удвоение значения только первого элемента массива
     */
    public static void example3() {
        int[] array = {1, 2, 3, 4, 5};
        array[0] = array[0] * 2;
        System.out.println(Arrays.toString(array));

        int[] array1 = {1, 2, 3, 4, 5};
        int[] doubledArray = new int[array1.length];
        doubledArray[0] = array1[0] * 2;
        for (int i = 1; i < array1.length; i++) {
            doubledArray[i] = array1[i];
        }
        System.out.println(Arrays.toString(doubledArray));
    }

    /**
     * Создание таблицы умножения для всех элементов массива
     * например если массив состоит из элементов [2,3,7,8,10]
     * сначала каждый элемент умножается на 2 затем каждый элемент умножается на 3 затем на 7 и т д
     */
    public static void table1() {
        int[] array = {2, 3, 7, 8, 10};
        int[][] multiplicationTable = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                multiplicationTable[i][j] = array[i] * array[j];
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(multiplicationTable[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void table2() {
        int[] array = {2, 3, 7, 8, 10};
        int[][] multiplicationTable = new int[array.length][array.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    multiplicationTable[i][j] = array[i] * array[i];
                } else {
                    multiplicationTable[i][j] = array[i] * array[j];
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(multiplicationTable[i][j] + " ");
            }
            System.out.println();
        }
    }


    /**
     * Пример хэш таблицы и ее вывод
     */
    void hashTableExample() {
        Map<String, Double> book = new HashMap<>();

        book.put("apple", 0.67);
        book.put("milk", 1.49);
        book.put("avocado", 1.49);

        for (Map.Entry<String, Double> entry : book.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }


    /**
     * Пример построения телефонной книги и вывод Дженни
     */
    void hashTablePhoneBook() {
        Map<String, Integer> phoneBook = new HashMap<>();

        phoneBook.put("jenny", 8675309);
        phoneBook.put("kent", 8675310); // это будет заменить предыдущее значение

        Integer phoneNumber = phoneBook.get("jenny");

        System.out.println(phoneNumber); // выведет 8675309
    }

    /**
     * Метод проверки пользователя
     */
    public static void checkVoter(String name) {
        Map<String, Boolean> voted = new HashMap<>();
        if (voted.containsKey(name) && voted.get(name)) {
            System.out.println("kick");
        } else {
            voted.put(name, true);
            System.out.println("let");
        }
    }

    /**
     * Проверка - хранится ли страница в Хеше
     */
    public static String getPage(String url) {
        Map<String, String> cache = new HashMap<>();
        if (cache.containsKey(url)) {
            return cache.get(url);
        } else {
            String data = getDataFromServer(url);
            cache.put(url, data);
            return data;
        }
    }
    private static String getDataFromServer(String url) {
        // реализация метода для получения данных с сервера
        return url;
    }



}
