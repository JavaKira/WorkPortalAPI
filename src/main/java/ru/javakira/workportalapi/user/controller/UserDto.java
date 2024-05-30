package ru.javakira.workportalapi.user.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.javakira.workportalapi.user.User;
import ru.javakira.workportalapi.user.UserCategory;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String surname;
    private String screenName;
    private UserCategory userCategory;
    private boolean employer;

    public static UserDto from(User user) {
        return UserDto
                .builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .surname(user.getSurname())
                .screenName(user.getScreenName().orElse("null"))
                .userCategory(user.getUserCategory())
                .employer(user.isEmployer())
                .build();
    }
}
