package com.d3stroya.restdatajpa2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hola")
    public String saludo() {
        return "Hola mundo";
    }
}
