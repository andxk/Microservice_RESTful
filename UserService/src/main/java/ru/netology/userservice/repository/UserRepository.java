package ru.netology.userservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.usercontract.User;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {
    private final Map<Integer, User> users = new ConcurrentHashMap<>();

    public UserRepository() {
        User u;
        int id = 0;

        u = new User(++id, "Andrey", "Petrov", "Moscow, Tverskaya, 18", "+7 999 001 10 20", "petrov@mail.ru");
        users.put(id, u);

        u = new User(++id, "Marina", "Svetlova", "Voronezh, Lenina, 73", "+7 900 101 11 21", "marina@email.ru");
        users.put(id, u);

//        System.out.println(users.get(1));
//        System.out.println(users.get(2));
//        System.out.println(users.get(3));
    }


    public Optional<User> getUserById (int userId) {
        return Optional.ofNullable(users.get(userId));
    }

}
