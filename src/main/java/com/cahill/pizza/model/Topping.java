package com.cahill.pizza.model;

import jakarta.persistence.*;

@Entity
public class Topping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topping_id")
    private Topping topping;

    private String name;

    private double price;

    private boolean isExtra;

}
