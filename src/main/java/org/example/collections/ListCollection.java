package org.example.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListCollection {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(2);

        Collections.sort(list);

    }
}
