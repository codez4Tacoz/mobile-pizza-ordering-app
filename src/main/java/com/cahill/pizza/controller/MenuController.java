package com.cahill.pizza.controller;

import com.cahill.pizza.manager.MenuManager;
import com.cahill.pizza.model.MenuItem;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MenuController {
    private final MenuManager menuManager;

    @GetMapping("/menu")
    ResponseEntity<List<MenuItem>> getMenu() {

        //TODO add error handling
        List<MenuItem> items = menuManager.getAllMenuItems();
        items.forEach(item -> {
            System.out.println(item.toString());
        });

        return ResponseEntity.ok(items);
    }
}
