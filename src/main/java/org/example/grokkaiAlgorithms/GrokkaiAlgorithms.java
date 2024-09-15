package org.example.grokkaiAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GrokkaiAlgorithms {

    public static int binarySearch() {
        String[] names = new String[128];
        String target = "Veselov";

        int low = 0;
        int high = names.length - 1;
        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            count++;

            if (names[mid].equals(target)) {
                System.out.println(mid);
                break;
            } else if (names[mid].compareTo(target) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int binarySearch2(int[] list, int item) {
        int low = 0;
        int high = list.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int guess = list[mid];

            if (guess == item) {
                return mid;
            } else if (guess < item) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Известна фамилия, нужно найти номер в телефонной книге
     * @param phoneBook
     * @param name
     */
    public static int binarySearch3(String[] phoneBook, String name) {
        int low = 0;
        int high = phoneBook.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String guess = phoneBook[mid].split(" ")[0];

            if (guess.equals(name)) {
                return mid;
            } else if (guess.compareTo(name) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }

    /**
     * Известен номер нужно найти фамилию в телефонной книге.
     * (Нужно провести поиск по всех книге)
     */
    public static String findSurname(String[] phoneBook, String phoneNumber) {
        for (String entry : phoneBook) {
            String[] parts = entry.split(" ");
            if (parts[1].equals(phoneNumber)) {
                return parts[0];
            }
        }
        return null;
    }

    /**
     * Нужно прочитать телефоны всех людей в телефонной книге
     */
    public static void readPhoneNumbers(String[] phoneBook) {
        for (String entry : phoneBook) {
            String[] parts = entry.split(" ");
            System.out.println("Phone number: " + parts[1]);
        }
    }

    /**
     * Нужно прочитать телефоны всех людей фамилии которых начинаются с буквы "A"
     * Вопрос с подвохом! В нем задействованы концепции.
     */
    public static void readPhoneNumbersStartingWithA(String[] phoneBook) {
        for (String entry : phoneBook) {
            String[] parts = entry.split(" ");
            if (parts[0].startsWith("A")) {
                System.out.println("Phone number: " + parts[1]);
            }
        }
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
}
