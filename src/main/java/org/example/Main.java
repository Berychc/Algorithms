package org.example;

public class Main {
    public static void main(String[] args) throws Exception {
//        int[] arr = new int[]{6, 2, 3, 7, 6, 8, 1, 0, 3};
        int a = 5, b = 10;

        int result = proveThat(a,b);
    }


    public static int proveThat(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        return temp;
    }


}