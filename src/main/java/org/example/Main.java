package org.example;


import java.util.Arrays;

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
        char[] array = {'e' ,'s', 'r', 'e', 'v', 'e', 'r'};
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

}