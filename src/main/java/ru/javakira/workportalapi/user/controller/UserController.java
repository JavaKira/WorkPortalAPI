package ru.javakira.workportalapi.user.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.javakira.workportalapi.jwt.JwtService;
import ru.javakira.workportalapi.user.UserService;

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
    public void register(UserRegisterRequest request) {

    }

    @PatchMapping("/update")
    public void update(UserUpdateRequest request) {

    }

    @PutMapping("/update/summary")
    public void updateSummary(UserSummaryUpdateRequest request) {

    }

    @PatchMapping("/update/credentials")
    public void updateCredentials(UserCredentialsUpdateRequest request) {

    }
}
