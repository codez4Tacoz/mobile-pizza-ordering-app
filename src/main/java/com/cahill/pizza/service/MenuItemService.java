package com.cahill.pizza.service;

import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.model.Pizza;
import com.cahill.pizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequiredArgsConstructor
public class MenuItemService {
    private final PizzaRepository pizzaRepository;

    public List<MenuItem> getAllMenuItems() {
        List<MenuItem> menuItems = new ArrayList<>();

        //We can add other menu item types here... such as appetizers, etc.
        List<Pizza> pizzas = pizzaRepository.findAll();
        menuItems.addAll(pizzas);

        return menuItems;
    }

}
