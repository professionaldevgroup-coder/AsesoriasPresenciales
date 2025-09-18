package com.grupostudiodemo.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {

    @GetMapping("HolaEndpoint")
    public String getDemoEndpoint(){
        return "Hola Mundo Demo WebApi";
    }
}
