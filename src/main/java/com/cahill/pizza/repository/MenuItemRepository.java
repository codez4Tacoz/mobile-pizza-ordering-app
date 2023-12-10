package com.cahill.pizza.repository;

import com.cahill.pizza.model.MenuItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.*;

public interface MenuItemRepository extends CrudRepository<MenuItem, Integer> {

    @NonNull
    List<MenuItem> findAll();
}
