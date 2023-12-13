package com.cahill.pizza.repository;

import com.cahill.pizza.model.MenuItem;
import com.cahill.pizza.model.Pizza;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface PizzaRepository extends CrudRepository<Pizza, Integer> {

    @NonNull
    List<Pizza> findAll();
}
