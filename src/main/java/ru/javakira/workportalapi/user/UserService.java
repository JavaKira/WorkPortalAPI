package ru.javakira.workportalapi.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;

    public void register(
        String firstName,
        String lastName,
        String surname,
        boolean employer,
        String phoneNumber,
        String email,
        String username,
        String password
    ) {
        User user = User
                .builder()
                .firstName(firstName)
                .lastName(lastName)
                .surname(surname)
                .employer(employer)
                .phoneNumber(phoneNumber)
                .email(email)
                .username(username)
                .password(passwordEncoder.encode(password))
                .build();

        repository.save(user);
    }

    public User user(long id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User with id %d doesnt exist".formatted(id)
            );

        return userOptional.get();
    }

    public User user(String username) {
        Optional<User> userOptional = repository.findByUsername(username);
        if (userOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "User with username %s doesnt exist".formatted(username)
            );

        return userOptional.get();
    }
}
