package com.example.springboot.demo_grupo_studio.Api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ExampleController {

    @GetMapping("/hola-mundo")
    public ResponseEntity<String> holaMundo() {
        return ResponseEntity.ok("Elemento encontrado"); // HTTP 200
    }
}
