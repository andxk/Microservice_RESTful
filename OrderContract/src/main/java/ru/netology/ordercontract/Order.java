package ru.netology.ordercontract;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    private int id;
    private int userId;
    private double amount;
    private String currency;
    private List<OrderItem> orderItems;
}
