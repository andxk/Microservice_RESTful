package ru.netology.orderservice.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import ru.netology.ordercontract.Order;
import ru.netology.ordercontract.OrderItem;

@Repository
public class OrderRepository {
    private final Map<Integer, List<Order>> orders = new ConcurrentHashMap<>();
    private int currentOrderId = 0;


    public List<Order> getOrdersByUserId(int userId) {
        return orders.get(userId);
    }


    public OrderRepository() {
        List<OrderItem> items;

        // User 1
        int currentUserId = 1;
        items = new ArrayList<>(List.of(
                new OrderItem("Хлеб", 2, 50),
                new OrderItem("Молоко", 1, 110),
                new OrderItem("Варенье", 3, 350)
        ));
        addOrderToUserId(currentUserId, items);

        items = new ArrayList<>(List.of(
                new OrderItem("Чай", 2, 350),
                new OrderItem("Кофе", 1, 1500),
                new OrderItem("Булка", 1, 100)
        ));
        addOrderToUserId(currentUserId, items);


        // User 2
        currentUserId = 2;
        items = new ArrayList<>(List.of(
                new OrderItem("Колесо", 4, 5000),
                new OrderItem("Насос", 1, 1100),
                new OrderItem("Вода", 2, 75)
        ));
        addOrderToUserId(currentUserId, items);

        items = new ArrayList<>(List.of(
                new OrderItem("Салат", 1, 150),
                new OrderItem("Колбаса", 1, 900),
                new OrderItem("Пиво", 2, 200)
        ));
        addOrderToUserId(currentUserId, items);

//        System.out.println(orders.get(1));
//        System.out.println(orders.get(2));
//        System.out.println(orders.get(3));

    }


    public void addOrderToUserId(int userId, List<OrderItem> items) {
        if (!orders.containsKey(userId)) {
            orders.put(userId, new ArrayList<>());
        }
        orders.get(userId).add(createOrder(userId, items));
    }


    private Order createOrder(int userId, List<OrderItem> items) {
        return Order.builder()
                .id(currentOrderId++)
                .userId(userId)
                .amount(items.stream().mapToDouble(e -> e.getQuantity() * e.getPrice()).sum())
                .currency("RUR")
                .orderItems(items)
                .build();
    }


}
