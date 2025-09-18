package com.example.springboot.demo_grupo_studio.Config;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Demo Grupo Studio API")
                .description("API de ejemplo con Spring Boot + Swagger (springdoc-openapi).")
                .version("1.0.0")
                .contact(new Contact()
                    .name("Equipo TPyL")
                    .email("equipo@ejemplo.com")));
    }
}
