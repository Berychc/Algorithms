package org.example.collections;

import java.util.*;

public class HashSetCollections {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        // Получаем множество пар ключ-значение
        Map.Entry<String, Integer> lastEntry = null;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            lastEntry = entry;
        }

        // Выводим последний элемент
        System.out.println("Last element: " + lastEntry.getKey() + " = " + lastEntry.getValue());
    }


}
