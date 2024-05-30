package ru.javakira.workportalapi.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.userdetails.UserDetails;
import ru.javakira.workportalapi.user.User;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public interface JwtService {
    String extractUsername(String token);

    long extractId(String token);

    <T> T functionUserId(HttpServletRequest request, Function<Long, T> userConsumer);

    void consumeUserId(HttpServletRequest request, Consumer<Long> userConsumer);

    Optional<String> token(HttpServletRequest request);

    String generateToken(User user);

    boolean isTokenValid(String token, UserDetails userDetails);
}
