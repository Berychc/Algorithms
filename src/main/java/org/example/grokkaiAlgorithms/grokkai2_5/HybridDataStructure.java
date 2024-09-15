package org.example.grokkaiAlgorithms.grokkai2_5;

import java.util.LinkedList;
import java.util.List;

public class HybridDataStructure {

    private List<List<String>> dataStructure = new LinkedList<>();

    public HybridDataStructure() {
        for (int i = 0; i < 26; i++) {
            dataStructure.add(new LinkedList<>());
        }
    }

    public void addUserName(String userName) {
        int index = userName.charAt(0) - 'a';
        if (index < 0 || index >= 26) {
            System.out.println("Error: Invalid user name: " + userName);
            return;
        }
        dataStructure.get(index).add(userName);
    }

    public boolean containsUserName(String userName) {
        int index = userName.charAt(0) - 'a';
        return dataStructure.get(index).contains(userName);
    }
}
