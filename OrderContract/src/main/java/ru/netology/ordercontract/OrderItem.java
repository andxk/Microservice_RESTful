package ru.netology.ordercontract;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderItem {
    private String orderName;
    private int quantity;
    private double price;
}
