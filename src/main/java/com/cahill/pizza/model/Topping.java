package com.cahill.pizza.model;

import jakarta.persistence.*;

@Entity
public class Topping {
    @Id
    private Long topping_id;


    private String name;

    private float price;

}
