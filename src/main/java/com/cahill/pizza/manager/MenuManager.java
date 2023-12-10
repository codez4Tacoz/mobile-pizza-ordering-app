package com.cahill.pizza.manager;

import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.repository.MenuItemRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class MenuManager {
    private final MenuItemRepository repository;

    public List<MenuItem> getAllMenuItems() {
        //TODO prepopulate with Flyaway or Liquibase
        repository.save(new MenuItem(1, "item 1", "item 1 desc", 5.00f));
        repository.save(new MenuItem(12, "item 12", "item 12 desc", 5.00f));

        return repository.findAll();
    }
}
