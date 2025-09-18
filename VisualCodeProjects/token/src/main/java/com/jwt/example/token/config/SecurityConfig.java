package com.jwt.example.token.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
          .csrf(csrf -> csrf.disable())
          .authorizeHttpRequests(auth -> auth
             .requestMatchers(
                 "/auth/**",
                 "/v3/api-docs/**", "/swagger-ui/**", "/swagger-ui.html")
             .permitAll()
             .anyRequest().authenticated()
          )
          .httpBasic(Customizer.withDefaults()); // solo para pruebas
        return http.build();
    }
}