package com.cahill.pizza.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "menu_items")
@NoArgsConstructor
@AllArgsConstructor
public class MenuItem {
    @Id
    private Integer id;
    private String name;

    @Column(nullable = true)
    private String description;

    //TODO when we add other menu item types, we'll add a unit price to menuItem class... but for now the pizza menu items will vary by
    //private Float unit_price;


}
