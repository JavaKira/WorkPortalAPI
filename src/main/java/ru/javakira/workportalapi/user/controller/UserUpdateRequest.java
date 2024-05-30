package ru.javakira.workportalapi.user.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.javakira.workportalapi.user.UserCategory;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserUpdateRequest {
    private String firstName;
    private String lastName;
    private String surname;
    private UserCategory userCategory;
    private boolean employer;
}
