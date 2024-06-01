package ru.javakira.workportalapi.user.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.javakira.workportalapi.jwt.JwtService;
import ru.javakira.workportalapi.user.UserService;
import ru.javakira.workportalapi.util.Validation;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {
    private final JwtService jwtService;
    private final UserService userService;

    @GetMapping
    public UserDto user(HttpServletRequest request) {
        return jwtService.functionUserId(request, (userId) -> UserDto.from(userService.user(userId)));
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRegisterRequest request) {
        if (!Validation.phoneNumber(request.getPhoneNumber()))
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Wrong phone number"
            );

        if (!Validation.email(request.getEmail()))
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Wrong email"
            );

        userService.register(
                request.getFirstName(),
                request.getLastName(),
                request.getSurname(),
                request.isEmployer(),
                request.getPhoneNumber(),
                request.getEmail(),
                request.getUsername(),
                request.getPassword()
        );
    }

    @PatchMapping("/update")
    public void update(@RequestBody UserUpdateRequest request) {
        //todo
    }

    @PutMapping("/update/summary")
    public void updateSummary(@RequestBody UserSummaryUpdateRequest request) {
        //todo
    }

    @PatchMapping("/update/credentials")
    public void updateCredentials(@RequestBody UserCredentialsUpdateRequest request) {
        //todo
    }
}
