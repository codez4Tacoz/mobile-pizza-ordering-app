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
    @Id
    private Integer pizzaId;

    private String name;
    private float basePrice;
/*    private PizzaSize size;

    private PizzaBase base;*/


    //private Set<Topping> toppings;


}
