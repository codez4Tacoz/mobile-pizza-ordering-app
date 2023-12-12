package com.cahill.pizza.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Table(name = "pizza")
@NoArgsConstructor
@AllArgsConstructor
public class Pizza extends MenuItem {

    @Enumerated(EnumType.STRING)
    private PizzaSize size;

    @Enumerated(EnumType.STRING)
    private PizzaBase base;

    @ManyToMany
    @JoinTable(name = "pizza_toppings",
            joinColumns = @JoinColumn(name = "pizza_id"),
            inverseJoinColumns = @JoinColumn(name = "topping_id"))
    private Set<Topping> toppings;
}
