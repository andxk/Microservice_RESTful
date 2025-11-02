package ru.netology.usercontract;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
public class User {
    private int id;
    private String name;
    private String surName;
    private String address;
    private String phoneNumber;
    private String email;
}
