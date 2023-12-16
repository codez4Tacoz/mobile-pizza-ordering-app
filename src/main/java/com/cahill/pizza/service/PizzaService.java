package com.cahill.pizza.service;

import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.model.Pizza;
import com.cahill.pizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepository pizzaRepository;

    public Pizza getPizzaMenuItem(Integer id) {
        Pizza pizza = pizzaRepository.getById(id);

        return pizza;
    }
}
