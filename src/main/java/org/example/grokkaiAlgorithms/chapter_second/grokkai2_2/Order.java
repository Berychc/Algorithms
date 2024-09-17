package org.example.grokkaiAlgorithms.chapter_second.grokkai2_2;

public class Order {

    String customerName;
    String dish;
    boolean isReady;

    public Order(String customerName, String dish) {
        this.customerName = customerName;
        this.dish = dish;
        this.isReady = false;
    }
}
