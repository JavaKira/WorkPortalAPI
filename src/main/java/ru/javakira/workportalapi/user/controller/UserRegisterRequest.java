package ru.javakira.workportalapi.user.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {
    private String firstName;
    private String lastName;
    private String surname;
    private boolean employer;

    private String phoneNumber;
    private String email;
    private String username;
    private String password;
}
