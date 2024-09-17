package org.example.grokkaiAlgorithms.chapter_second.grokkai2_2;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    List<Order> orders = new ArrayList<>();
    List<Order> orderQueue = new ArrayList<>();

    public void addOrder(String customerName, String dish) {
        Order order = new Order(customerName, dish);
        orders.add(order);
        orderQueue.add(order);
        System.out.println("Order added: " + customerName + " - " + dish);
    }

    public void startPreparingOrders() {
        while (!orderQueue.isEmpty()) {
            Order order = orderQueue.get(0);
            order.isReady = true;
            orderQueue.remove(0);
            System.out.println("Order ready: " + order.customerName + " - " + order.dish);
        }
    }
}
