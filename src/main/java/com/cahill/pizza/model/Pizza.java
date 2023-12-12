package com.cahill.pizza.model;

import jakarta.persistence.*;

import java.util.Set;

public class Pizza extends MenuItem {
    @ManyToOne
    @JoinColumn(name = "pizza_size_id")
    private PizzaSize size;

    @Enumerated(EnumType.STRING)
    private PizzaBase base;
    @ManyToMany
    @JoinTable(name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id"))
    private Set<Topping> toppings;
}
