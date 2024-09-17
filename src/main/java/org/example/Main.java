package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Double> book = new HashMap<>();

        book.put("apple", 0.67);
        book.put("milk", 1.49);
        book.put("avocado", 1.49);

        for (Map.Entry<String, Double> entry : book.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

}