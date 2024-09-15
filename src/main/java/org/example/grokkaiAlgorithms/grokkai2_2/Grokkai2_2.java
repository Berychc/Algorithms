package org.example.grokkaiAlgorithms.grokkai2_2;

import java.util.Scanner;

/**
 * Допустим выпишите приложение для приема заказов посетителей ресторана,
 * приложение должно хранить список заказов официант добавляют заказы в список повора читает заказы из списка
 * и вы выполняете их заказы образуют очередь официант добавляют заказы и
 * в конец очереди повора берет первый заказ очереди начинает готовить
 *
 * @Entity Restaurant && Order
 */
public class Grokkai2_2 {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add order");
            System.out.println("2. Start preparing orders");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String customerName = scanner.next();
                    System.out.print("Enter dish: ");
                    String dish = scanner.next();
                    restaurant.addOrder(customerName, dish);
                    break;
                case 2:
                    restaurant.startPreparingOrders();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
