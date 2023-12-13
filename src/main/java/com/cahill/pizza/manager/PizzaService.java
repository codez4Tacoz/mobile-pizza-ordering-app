package com.cahill.pizza.manager;

import com.cahill.pizza.model.Pizza;
import com.cahill.pizza.repository.PizzaRepository;
import lombok.RequiredArgsConstructor;

import javax.inject.Named;
import java.util.List;

@Named
@RequiredArgsConstructor
public class PizzaService {
    private final PizzaRepository repository;

    public List<Pizza> getAllPizzas() {

        return repository.findAll();
    }

}
