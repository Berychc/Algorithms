package org.example;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }


    /**
     * Find the maximum and minimum element in an array
     *
     * @param array
     * @return max and min element
     */

    private static double findMax(double[] array) {
        if (array.length == 0) {
            return 0;
        }

        double tmpMin = array[0];
        double tmpMax = array[0];
        double[] mins = new double[4];
        double[] maxs = new double[4];
        for (int i = 0; i < array.length; i++) {
            mins[0] = tmpMin - array[i];
            maxs[0] = tmpMax - array[i];

            mins[1] = tmpMin + array[i];
            maxs[1] = tmpMax + array[i];

            mins[2] = tmpMin * array[i];
            maxs[2] = tmpMax * array[i];

            if (array[i] != 0) {
                mins[3] = tmpMin / array[i];
                maxs[3] = tmpMax / array[i];
            }

            tmpMax = Math.max(max(mins), max(maxs));
            tmpMin = Math.min(min(mins), min(maxs));

        }
        return tmpMax;
    }

    private static double max(double[] arr) {
        return Arrays.stream(arr).max().orElse(Double.MIN_VALUE);
    }

    private static double min(double[] arr) {
        return Arrays.stream(arr).min().orElse(Double.MAX_VALUE);
    }


    /**
     * Problem about oranges
     * <p>
     * return in how many minutes will there be rotten oranges
     */

    private int orangesRotting(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    infect(grid, i, j);
                }
            }
        }

        var minInfectingTime = 2;
        for (int[] row : grid) {
            for (int rottenOrange : row) {
                if (rottenOrange == 1) return -1;
                if (rottenOrange > minInfectingTime) minInfectingTime = rottenOrange;
            }
        }

        return minInfectingTime - 2;
    }

    private void infect(int[][] grid, int i, int j) {
        var CONFIRMED_PATIENT = grid[i][j];

        if ((i > 0) && (grid[i - 1][j] == 1 || grid[i - 1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i - 1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i - 1, j);
        }

        if ((j > 0) && (grid[i][j - 1] == 1 || grid[i][j - 1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j - 1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j - 1);
        }

        if ((i + 1 < grid.length) && (grid[i + 1][j] == 1 || grid[i + 1][j] > CONFIRMED_PATIENT + 1)) {
            grid[i + 1][j] = CONFIRMED_PATIENT + 1;
            infect(grid, i + 1, j);
        }

        if ((j + 1 < grid[0].length) && (grid[i][j + 1] == 1 || grid[i][j + 1] > CONFIRMED_PATIENT + 1)) {
            grid[i][j + 1] = CONFIRMED_PATIENT + 1;
            infect(grid, i, j + 1);
        }
    }


    /**
     * Reverse array char
     *
     * @return reversed array
     */
    private static void reverseCharArray() {
        char[] array = {'e', 's', 'r', 'e', 'v', 'e', 'r'};
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }

    /**
     * Reverse array int
     *
     * @return reversed array
     */
    private static void reverseIntArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }

    /**
     * Reverse array string
     *
     * @param array
     * @return reversed array
     */
    private static void reverseStringArray(String[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            String temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }

    /**
     * Add element to array
     *
     * @param item
     * @return array with element
     */
    private static String add(String item) {
        List<String> items = new ArrayList<>();
        items.add(item);
        return item;
    }

    /**
     * Add element
     *
     * @param index , item
     * @return array with element
     */
    private String add(int index, String item) {
        List<String> items = new ArrayList<>();
        if (index < 0 || index > items.size()) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
        items.add(index, item);
        return item;
    }

    /**
     * Set element
     *
     * @param index , item
     * @return array with element
     */
    private String set(int index, String item) {
        List<String> items = new ArrayList<>();
        if (index < 0 || index > items.size()) {
            throw new IndexOutOfBoundsException("Invalid Index: " + index);
        }
        items.set(index, item);
        return item;
    }

    /**
     * remove element
     *
     * @param item
     * @return array with element
     */
    private String remove(String item) {
        List<String> items = new ArrayList<>();
        if (items.contains(item)) {
            String removedItem = items.remove(items.indexOf(item));
            return removedItem;
        } else {
            throw new IllegalArgumentException("Item not found in the list");
        }
    }

    /**
     * remove Index
     *
     * @param index
     * @return array with element
     */
    private String remove(int index) {
        List<String> indexS = new ArrayList<>();
        if (index >= 0 && index < indexS.size()) {
            String removedItem = indexS.remove(index);
            return removedItem;
        } else {
            throw new IndexOutOfBoundsException("Item not found in the list");
        }
    }

    /**
     * Checking for the existence of an element.
     *
     * @param item
     * @return true if item is present in the list
     */
    private boolean contains(String item) {
        List<String> items = new ArrayList<>();
        return items.contains(item);
    }

    /**
     * Search element
     *
     * @param item
     * @return index == 1 && if index not found return -1
     */
    private int indexOf(String item) {
        List<String> items = new ArrayList<>();
        return items.indexOf(item);
    }

    /**
     * Search element from the end
     *
     * @param item
     * @return index == 1 && if index not found return -1
     */
    private int lastIndexOf(String item) {
        List<String> items = new ArrayList<>();
        return items.lastIndexOf(item);
    }

    /**
     * get element byn index
     *
     * @param index
     * @return element
     */
    private String get(int index) {
        List<String> items = new ArrayList<>();
        if (index < 0 || index >= items.size()) {
            throw new IndexOutOfBoundsException("Index goes beyond the list");
        }
        return items.get(index);
    }

    /**
     * Compare current list with another
     *
     * @param otherList
     * @return true if both lists are equal
     */
    private final List<String> listByEquals = new ArrayList<>();

    public boolean equals(List<String> otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("OtherList parameter cannot be null");
        }
        return this.listByEquals.equals(otherList);
    }

    /**
     * Return the actual number of elements
     *
     * @return actual number of elements
     */
    private int size() {
        List<String> items = new ArrayList<>();
        return items.size();
    }

    /**
     * Return true if there are no elements in the list, else false
     *
     * @return true if there are no elements in the list, else false
     */
    private boolean isEmpty() {
        List<String> items = new ArrayList<>();
        if (items.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove all items from a list
     */
    private void clear() {
        List<String> items = new ArrayList<>();
        items.clear();
    }

    /**
     * Create a new array
     *
     * @return list
     */
    private List<String> myList = new ArrayList<>();

    // Добавление элементов в список
    public void addString(String str) {
        myList.add(str);
    }

    // Метод для преобразования списка в массив и его возврат
    public String[] toArray() {
        String[] array = new String[myList.size()];
        array = myList.toArray(array);
        return array;
    }

 }