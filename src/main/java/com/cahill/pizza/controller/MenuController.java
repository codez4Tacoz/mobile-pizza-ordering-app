package com.cahill.pizza.controller;

import com.cahill.pizza.manager.PizzaService;
import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.model.Pizza;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final PizzaService pizzaService;

    @GetMapping("/menu")
    public ResponseEntity<List<MenuItem>> getMenu() {
        try {
            System.out.println("inside method");
            List<Pizza> pizzas = pizzaService.getAllPizzas();

            List<MenuItem> items = new ArrayList<>();

            System.out.println("inside method pizzas " + pizzas.size());
            pizzas.forEach(pizza -> {
                items.add(new MenuItem(pizza.getPizzaId(), pizza.getName(), null, pizza.getBasePrice()));
            });

            return ResponseEntity.ok(items);
        } catch (Exception e) {
            log.error("Error while fetching menu items", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
