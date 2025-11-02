package ru.netology.bffservice.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import ru.netology.bffservice.model.BffResponse;
import ru.netology.ordercontract.Order;
import ru.netology.usercontract.User;

import java.util.List;

@Service
public class BffService {
    private final RestClient restClient = RestClient.create();

    @Value("${user.service.uri}")
    private String userServiceUri;

    @Value("${order.service.uri}")
    private String orderServiceUri;


    public BffResponse getByUserId(int userId) {
        User user = getUserById(userId);
        if (user == null) {
            return new BffResponse(null, null);
        }
        List<Order> orders = getOrdersByUserId(userId);
        return new BffResponse(user, orders);
    }


    public User getUserById (int userId) {
        return restClient.get()
                .uri(userServiceUri + "/{userId}", userId)
                .retrieve()
                .body(User.class);
    }


    public List<Order> getOrdersByUserId (int userId) {
        return restClient.get()
                .uri(orderServiceUri + "/{userId}", userId)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

}
