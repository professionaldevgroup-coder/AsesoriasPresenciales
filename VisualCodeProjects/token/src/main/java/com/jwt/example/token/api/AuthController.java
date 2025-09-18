package com.jwt.example.token.api;

import com.jwt.example.token.security.JwtService;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtService jwtService;

    public AuthController(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/token")
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) {
        // Demo: validación simple (reemplaza con AuthenticationManager + UserDetailsService)
        if (!"admin".equals(request.getUsername()) || !"admin".equals(request.getPassword())) {
            return ResponseEntity.status(401).build();
        }
        UserDetails user = User.withUsername(request.getUsername()).password("{noop}admin").roles("USER").build();
        String jwt = jwtService.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(jwt));
    }

    @Data
    public static class LoginRequest {
        @NotBlank private String username;
        @NotBlank private String password;
    }

    @Data
    public static class TokenResponse {
        private final String token;
        private final String tokenType = "Bearer";
    }
}