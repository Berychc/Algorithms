package org.example.grokkaiAlgorithms.grokkai2_5;

public class Grokkai2_5 {

    public static void main(String[] args) {
        HybridDataStructure hybridDataStructure = new HybridDataStructure();

        hybridDataStructure.addUserName("Eddie");
        hybridDataStructure.addUserName("Zahir");

        System.out.println(hybridDataStructure.containsUserName("Eddie")); // true
        System.out.println(hybridDataStructure.containsUserName("Zahir")); // true
        System.out.println(hybridDataStructure.containsUserName("Alex")); // false
    }
}