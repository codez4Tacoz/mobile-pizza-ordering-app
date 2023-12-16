package com.cahill.pizza.controller;

import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.model.Pizza;
import com.cahill.pizza.service.MenuItemService;
import com.cahill.pizza.service.PizzaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final MenuItemService menuItemService;
    private final PizzaService pizzaService;

    @GetMapping
    public ResponseEntity<List<MenuItem>> getMenu() {
        try {
            List<MenuItem> items = menuItemService.getAllMenuItems();
            return ResponseEntity.ok(items);
        } catch (Exception e) {
            log.error("Error while fetching menu items", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/pizza/{id}")
    public ResponseEntity<Pizza> getPizzaMenuItem(@PathVariable Integer id) {
        try {
            Pizza p = pizzaService.getPizzaMenuItem(id);
            return ResponseEntity.ok(p);
        } catch (Exception e) {
            log.error("Error while fetching pizza menu item", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
