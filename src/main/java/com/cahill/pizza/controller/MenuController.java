package com.cahill.pizza.controller;

import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.service.MenuItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Slf4j
public class MenuController {

    private final MenuItemService pizzaService;

    @GetMapping("/menu")
    public ResponseEntity<List<MenuItem>> getMenu() {
        try {
            System.out.println("inside method");
            List<MenuItem> items = pizzaService.getAllMenuItems();
            System.out.println("menuitems: " + items.size());

            return ResponseEntity.ok(items);
        } catch (Exception e) {
            log.error("Error while fetching menu items", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
