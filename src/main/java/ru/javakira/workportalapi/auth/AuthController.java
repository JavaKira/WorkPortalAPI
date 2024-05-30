package ru.javakira.workportalapi.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/*
todo /api/logout
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/auth")
    public AuthResponse auth(AuthRequest request) {
        String jwt = authService.auth(request.getUsername(), request.getPassword());
        return new AuthResponse(jwt);
    }

    @PostMapping("/logout")
    public void logout() {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Logout not implemented"
        );
    }
}
