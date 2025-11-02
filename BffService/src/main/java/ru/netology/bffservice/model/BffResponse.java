package ru.netology.bffservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ru.netology.ordercontract.Order;
import ru.netology.usercontract.User;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class BffResponse {
    private User user;
    private List<Order> orderList;
}
