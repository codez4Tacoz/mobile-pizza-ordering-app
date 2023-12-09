package com.cahill.pizza.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MenuController {

    @GetMapping("/hello")
    ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Greetings & salutations from menu controller!");
    }
}
